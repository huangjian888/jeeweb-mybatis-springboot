package com.company.manerger.sys.common.quartz;

import com.company.manerger.sys.common.quartz.constant.ScheduleConstants;
import com.company.manerger.sys.common.quartz.data.ScheduleJob;
import com.company.manerger.sys.common.quartz.exception.QuartzException;
import com.company.manerger.sys.common.quartz.factory.QuartzJobFactory;
import com.company.manerger.sys.common.quartz.factory.QuartzJobFactoryDisallowConcurrentExecution;
import com.company.manerger.sys.common.utils.SpringContextHolder;
import com.company.manerger.sys.common.utils.StringUtils;
import com.google.common.collect.Lists;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @description: 计划任务管理
 *
 */
public class QuartzManager {

	protected Logger logger = LoggerFactory.getLogger(getClass());


	/**
	 * 获取触发器key
	 */
	public static TriggerKey getTriggerKey(ScheduleJob job)
	{
		return TriggerKey.triggerKey(job.getJobName(),job.getJobGroup());
	}

	/**
	 * 获取jobKey
	 */
	public static JobKey getJobKey(ScheduleJob job)
	{
		return JobKey.jobKey(job.getJobName(),job.getJobGroup());
	}

	public static CronScheduleBuilder handleCronScheduleMisfirePolicy(ScheduleJob scheduleJob, CronScheduleBuilder cb)
			throws QuartzException
	{
		String misfirePolicy = scheduleJob.getMisfirePolicy();
		if (StringUtils.isEmpty(misfirePolicy)){
			misfirePolicy = ScheduleConstants.MISFIRE_DEFAULT;
		}
		switch (misfirePolicy)
		{
			case ScheduleConstants.MISFIRE_DEFAULT:
				return cb;
			case ScheduleConstants.MISFIRE_IGNORE_MISFIRES:
				return cb.withMisfireHandlingInstructionIgnoreMisfires();
			case ScheduleConstants.MISFIRE_FIRE_AND_PROCEED:
				return cb.withMisfireHandlingInstructionFireAndProceed();
			case ScheduleConstants.MISFIRE_DO_NOTHING:
				return cb.withMisfireHandlingInstructionDoNothing();
			default:
				throw new QuartzException("The task misfire policy '" + scheduleJob.getMisfirePolicy()
						+ "' cannot be used in cron schedule tasks");
		}
	}
	/**
	 * 添加任务
	 * 
	 * @param job
	 * @throws SchedulerException
	 */
	public void addJob(ScheduleJob job) throws SchedulerException {
		if (job == null || !ScheduleConstants.STATUS_RUNNING.equals(job.getJobStatus())) {
			return;
		}
		Scheduler scheduler = SpringContextHolder.getBean(SchedulerFactoryBean.class).getScheduler();
		logger.debug(scheduler + ".......................................................................................add");
		TriggerKey triggerKey = getTriggerKey(job);
		CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
		// 不存在，创建一个
		if (null == trigger) {
			Class<? extends Job> clazz = ScheduleConstants.CONCURRENT_IS.equals(job.getIsConcurrent())
					? QuartzJobFactory.class : QuartzJobFactoryDisallowConcurrentExecution.class;
			JobDetail jobDetail = JobBuilder.newJob(clazz).storeDurably().requestRecovery().withIdentity(getJobKey(job)).withDescription(job.getDescription()).build();
			jobDetail.getJobDataMap().put(ScheduleConstants.TASK_JOB_BAEN_KEY, job);
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
			// 执行策略
			scheduleBuilder = handleCronScheduleMisfirePolicy(job, scheduleBuilder);
			trigger = TriggerBuilder.newTrigger().withIdentity(getTriggerKey(job))
					.withSchedule(scheduleBuilder).build();
			scheduler.scheduleJob(jobDetail, trigger);
		} else {
			// Trigger已存在，那么更新相应的定时设置
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
			// 执行策略
			scheduleBuilder = handleCronScheduleMisfirePolicy(job, scheduleBuilder);
			// 按新的cronExpression表达式重新构建trigger
			trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
			// 按新的trigger重新设置job执行
			scheduler.rescheduleJob(triggerKey, trigger);
		}
		// 暂停任务
		if (job.equals(ScheduleConstants.STATUS_NOT_RUNNING))
		{
			pauseJob(job);
		}
	}

	/**
	 * 获取所有计划中的任务列表
	 * 
	 * @return
	 * @throws SchedulerException
	 */
	public List<ScheduleJob> getAllJob() throws SchedulerException {
		Scheduler scheduler =  SpringContextHolder.getBean(SchedulerFactoryBean.class).getScheduler();
		GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
		Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
		List<ScheduleJob> jobList = new ArrayList<ScheduleJob>();
		for (JobKey jobKey : jobKeys) {
			List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
			for (Trigger trigger : triggers) {
				JobDetail jobDetail = scheduler.getJobDetail(jobKey);
				ScheduleJob job =  (ScheduleJob)jobDetail.getJobDataMap().get(ScheduleConstants.TASK_JOB_BAEN_KEY);
				Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
				job.setJobStatus(triggerState.name());
				if (trigger instanceof CronTrigger) {
					CronTrigger cronTrigger = (CronTrigger) trigger;
					String cronExpression = cronTrigger.getCronExpression();
					job.setCronExpression(cronExpression);
				}
				jobList.add(job);
			}
		}
		return jobList;
	}

	/**
	 * 所有正在运行的job
	 * 
	 * @return
	 * @throws SchedulerException
	 */
	public List<ScheduleJob> getRunningJob() throws SchedulerException {
		Scheduler scheduler =  SpringContextHolder.getBean(SchedulerFactoryBean.class).getScheduler();
		List<JobExecutionContext> executingJobs = scheduler.getCurrentlyExecutingJobs();
		List<ScheduleJob> jobList = new ArrayList<ScheduleJob>(executingJobs.size());
		for (JobExecutionContext executingJob : executingJobs) {
			JobDetail jobDetail = executingJob.getJobDetail();
			JobKey jobKey = jobDetail.getKey();
			Trigger trigger = executingJob.getTrigger();
			ScheduleJob job = (ScheduleJob)jobDetail.getJobDataMap().get(ScheduleConstants.TASK_JOB_BAEN_KEY);
			Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
			job.setJobStatus(triggerState.name());
			if (trigger instanceof CronTrigger) {
				CronTrigger cronTrigger = (CronTrigger) trigger;
				String cronExpression = cronTrigger.getCronExpression();
				job.setCronExpression(cronExpression);
			}
			jobList.add(job);
		}
		return jobList;
	}

	/**
	 * 暂停一个job
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public void pauseJob(ScheduleJob scheduleJob) throws SchedulerException {
		Scheduler scheduler =  SpringContextHolder.getBean(SchedulerFactoryBean.class).getScheduler();
		JobKey jobKey = getJobKey(scheduleJob);
		scheduler.pauseJob(jobKey);
	}

	/**
	 * 恢复一个job
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public void resumeJob(ScheduleJob scheduleJob) throws SchedulerException {
		Scheduler scheduler =  SpringContextHolder.getBean(SchedulerFactoryBean.class).getScheduler();
		JobKey jobKey = getJobKey(scheduleJob);
		scheduler.resumeJob(jobKey);
	}

	/**
	 * 删除一个job
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public void deleteJob(ScheduleJob scheduleJob) throws SchedulerException {
		Scheduler scheduler =  SpringContextHolder.getBean(SchedulerFactoryBean.class).getScheduler();
		JobKey jobKey = getJobKey(scheduleJob);
		scheduler.deleteJob(jobKey);
	}

	/**
	 * 立即执行job
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public void runAJobNow(ScheduleJob scheduleJob) throws SchedulerException {
		Scheduler scheduler =  SpringContextHolder.getBean(SchedulerFactoryBean.class).getScheduler();
		JobKey jobKey = getJobKey(scheduleJob);
		scheduler.triggerJob(jobKey);
	}

	/**
	 * 更新job时间表达式
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public void updateJobCron(ScheduleJob scheduleJob) throws SchedulerException {
		Scheduler scheduler =  SpringContextHolder.getBean(SchedulerFactoryBean.class).getScheduler();
		TriggerKey triggerKey = getTriggerKey(scheduleJob);
		CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression());
		// 执行策略
		scheduleBuilder = handleCronScheduleMisfirePolicy(scheduleJob, scheduleBuilder);

		trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
		// 参数
		trigger.getJobDataMap().put(ScheduleConstants.TASK_JOB_BAEN_KEY, scheduleJob);
		scheduler.rescheduleJob(triggerKey, trigger);

		// 暂停任务
		if (scheduleJob.getJobStatus().equals(ScheduleConstants.STATUS_NOT_RUNNING))
		{
			pauseJob(scheduleJob);
		}
	}

	/**
	 * 清空任务
	 *
	 * @throws SchedulerException
	 */
	public void empty() throws SchedulerException {
		Scheduler scheduler =  SpringContextHolder.getBean(SchedulerFactoryBean.class).getScheduler();
		GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
		Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
		scheduler.deleteJobs(Lists.newArrayList(jobKeys));
	}
}