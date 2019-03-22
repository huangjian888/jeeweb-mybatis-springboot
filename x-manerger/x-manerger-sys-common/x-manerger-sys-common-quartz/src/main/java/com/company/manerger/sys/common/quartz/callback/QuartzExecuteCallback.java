package com.company.manerger.sys.common.quartz.callback;

import com.company.manerger.sys.common.quartz.data.ScheduleJob;

/**
 * @description: 执行回掉
 */
public interface QuartzExecuteCallback {

    /**
     * 执行开始
     * @param scheduleJob
     */
    void onStart(ScheduleJob scheduleJob);
    /**
     * 当执行成功
     * @param scheduleJob
     * @param message
     */
    void onSuccess(ScheduleJob scheduleJob,String message);

    /**
     * 执行失败
     * @param scheduleJob
     * @param e
     * @param message
     */
    void onFailure(ScheduleJob scheduleJob,Exception e,String message);
}
