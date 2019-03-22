package com.company.manerger.sys.common.base.disruptor;

/**
 * @description: 内容传递
 *
 */
public class TaskEvent {
   private Task task;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}