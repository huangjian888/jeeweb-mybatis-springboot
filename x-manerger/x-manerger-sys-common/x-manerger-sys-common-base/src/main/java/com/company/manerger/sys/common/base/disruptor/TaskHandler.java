package com.company.manerger.sys.common.base.disruptor;

import com.lmax.disruptor.WorkHandler;

/**
 * @description: 内容消费者
 *
 */
public class TaskHandler implements WorkHandler<TaskEvent> {

	@Override
	public void onEvent(TaskEvent event) throws Exception {
		//运行任务
		event.getTask().run();
	}

}