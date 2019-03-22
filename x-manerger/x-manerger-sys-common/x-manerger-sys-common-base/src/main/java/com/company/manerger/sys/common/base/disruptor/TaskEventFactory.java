package com.company.manerger.sys.common.base.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @description: 定义事件工厂
 *
 */
public class TaskEventFactory implements EventFactory<TaskEvent> {
	public TaskEvent newInstance() {
		return new TaskEvent();
	}
}