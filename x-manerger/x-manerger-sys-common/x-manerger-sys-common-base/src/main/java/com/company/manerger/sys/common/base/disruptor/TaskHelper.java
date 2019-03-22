package com.company.manerger.sys.common.base.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.IgnoreExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskHelper {

	private int handlerCount = 1;
	private int bufferSize = 1024;
	private Disruptor<TaskEvent> disruptor;
	private TaskEventProducer taskEventProducer;

	public TaskHelper() {

	}

	public TaskHelper(int handlerCount, int bufferSize) {
		this.handlerCount = handlerCount;
		this.bufferSize = bufferSize;
	}

	@SuppressWarnings("deprecation")
	@PostConstruct
	private void start() {
		// Executor that will be used to construct new threads for consumers
		Executor executor = Executors.newCachedThreadPool();

		// The factory for the event
		TaskEventFactory factory = new TaskEventFactory();

		// Specify the size of the ring buffer, must be power of 2.

		// Construct the Disruptor
		// 单线程模式，获取额外的性能
		disruptor = new Disruptor<TaskEvent>(factory, bufferSize, executor, ProducerType.SINGLE,
				new BlockingWaitStrategy());
		List<TaskHandler> TaskHandlers = new ArrayList<>();
		for (int i = 0; i < handlerCount; i++) {
			TaskHandlers.add(new TaskHandler());
		}
		disruptor.handleExceptionsWith(new IgnoreExceptionHandler());
		// 多个消费者，每个消费者竞争消费不同数据
		disruptor.handleEventsWithWorkerPool(TaskHandlers.toArray(new TaskHandler[TaskHandlers.size()]));
		// Start the Disruptor, starts all threads running
		disruptor.start();

		// Get the ring buffer from the Disruptor to be used for publishing.
		RingBuffer<TaskEvent> ringBuffer = disruptor.getRingBuffer();
		taskEventProducer = new TaskEventProducer(ringBuffer);
	}

	/**
	 * 停止
	 */
	public void shutdown() {
		doHalt();
	}

	private void doHalt() {
		disruptor.halt();
	}

	public void doTask(Task task) {
		taskEventProducer.doTask(task);
	}

	public int getHandlerCount() {
		return handlerCount;
	}

	public void setHandlerCount(int handlerCount) {
		this.handlerCount = handlerCount;
	}

	public int getBufferSize() {
		return bufferSize;
	}

	public void setBufferSize(int bufferSize) {
		this.bufferSize = bufferSize;
	}
}