package cn.jeeweb.modules.task.service;

import cn.jeeweb.core.common.service.ICommonService;
import cn.jeeweb.modules.task.entity.ScheduleJob;
import org.quartz.SchedulerException;

/**
 * @Title: 任务
 * @Description: 任务
 * @author jeeweb
 * @date 2017-05-09 23:22:51
 * @version V1.0
 *
 */
public interface IScheduleJobService extends ICommonService<ScheduleJob> {
	/**
	 * 
	 * @title: initSchedule
	 * @description: 初始化任务
	 * @throws SchedulerException
	 * @return: void
	 */
	public void initSchedule() throws SchedulerException;

	/**
	 * 更改状态
	 * 
	 * @throws SchedulerException
	 */
	public void changeStatus(String jobId, String cmd) throws SchedulerException;

	/**
	 * 更改任务 cron表达式
	 * 
	 * @throws SchedulerException
	 */
	public void updateCron(String jobId) throws SchedulerException;
}
