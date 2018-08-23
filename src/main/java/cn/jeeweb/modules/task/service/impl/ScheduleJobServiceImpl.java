package cn.jeeweb.modules.task.service.impl;

import cn.jeeweb.core.common.service.impl.CommonServiceImpl;
import cn.jeeweb.core.quartz.QuartzManager;
import cn.jeeweb.modules.task.entity.ScheduleJob;
import cn.jeeweb.modules.task.mapper.ScheduleJobMapper;
import cn.jeeweb.modules.task.service.IScheduleJobService;
import cn.jeeweb.modules.task.utils.ScheduleJobUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @Title: 任务
 * @Description: 任务
 * @author jeeweb
 * @date 2017-05-09 23:22:51
 * @version V1.0
 *
 */
@Transactional
@Service("scheduleJobService")
public class ScheduleJobServiceImpl extends CommonServiceImpl<ScheduleJobMapper, ScheduleJob>
		implements IScheduleJobService {
	private QuartzManager quartzManager;

	@Override
	public void updateCron(String jobId) throws SchedulerException {
		ScheduleJob scheduleJob = selectById(jobId);
		if (scheduleJob == null) {
			return;
		}
		if (cn.jeeweb.core.quartz.data.ScheduleJob.STATUS_RUNNING.equals(scheduleJob.getJobStatus())) {
			quartzManager.updateJobCron(ScheduleJobUtils.entityToData(scheduleJob));
		}
		 super.insertOrUpdate(scheduleJob);
	}

	@Override
	public void changeStatus(String jobId, String cmd) throws SchedulerException {
		ScheduleJob scheduleJob = selectById(jobId);
		if (scheduleJob == null) {
			return;
		}
		if ("stop".equals(cmd)) {
			quartzManager.deleteJob(ScheduleJobUtils.entityToData(scheduleJob));
			scheduleJob.setJobStatus(cn.jeeweb.core.quartz.data.ScheduleJob.STATUS_NOT_RUNNING);
		} else if ("start".equals(cmd)) {
			scheduleJob.setJobStatus(cn.jeeweb.core.quartz.data.ScheduleJob.STATUS_RUNNING);
			quartzManager.addJob(ScheduleJobUtils.entityToData(scheduleJob));
		}
		 super.insertOrUpdate(scheduleJob);
	}

	@Override
	public boolean deleteById(Serializable id) {
		try {
			ScheduleJob scheduleJob = selectById(id);
			quartzManager.deleteJob(ScheduleJobUtils.entityToData(scheduleJob));
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return super.deleteById(id);
	}

	@Override
	public void initSchedule() throws SchedulerException {
		// 这里获取任务信息数据
		quartzManager = new QuartzManager();
		List<ScheduleJob> jobList = selectList(new EntityWrapper<ScheduleJob>());
		for (ScheduleJob scheduleJob : jobList) {
			quartzManager.addJob(ScheduleJobUtils.entityToData(scheduleJob));
		}
	}

}
