package com.company.manerger.sys.common.base.disruptor;

import com.lmax.disruptor.RingBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description: 内容生产者
 *
 */
public class TaskEventProducer {
	private static Logger logger = LoggerFactory.getLogger(TaskEventProducer.class);
	private final RingBuffer<TaskEvent> ringBuffer;

	public TaskEventProducer(RingBuffer<TaskEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}

	public void doTask(Task task) {
		// 获取下一个序号
		long sequence = ringBuffer.next();
		try {
			// 写入数据
			TaskEvent emailEvent = ringBuffer.get(sequence);
			emailEvent.setTask(task);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		} finally {
			// 通知消费者该资源可以消费了
			ringBuffer.publish(sequence);
		}
	}
}