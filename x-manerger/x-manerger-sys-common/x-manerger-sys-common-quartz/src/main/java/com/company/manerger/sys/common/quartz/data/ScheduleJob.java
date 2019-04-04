package com.company.manerger.sys.common.quartz.data;

import java.io.Serializable;

/**
 * @description: 计划任务信息
 *
 */
public class ScheduleJob implements Serializable {
	private static final long serialVersionUID = 1L;
    private String jobId;
	/**
	 * 任务名称
	 */
	private String jobName;
	/**
	 * 任务分组
	 */
	private String jobGroup;
	/**
	 * 任务状态 是否启动任务
	 */
	private String jobStatus;

	/**
	 * cron表达式
	 */
	private String cronExpression;

	/**
	 * 类加载方式
	 */
	private String loadWay;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 任务是否有状态
	 */
	private String isConcurrent;

	/**
	 * 任务调用的方法名
	 */
	private String methodName;

	/**
	 * 任务调用的参数
	 */
	private String methodParams;
	/**
	 * 执行策略
	 */
	private String misfirePolicy;

	private String executeClass;

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobGroup() {
		return jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	public String getLoadWay() {
		return loadWay;
	}

	public void setLoadWay(String loadWay) {
		this.loadWay = loadWay;
	}

	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsConcurrent() {
		return isConcurrent;
	}

	public void setIsConcurrent(String isConcurrent) {
		this.isConcurrent = isConcurrent;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getMethodParams() {
		return methodParams;
	}

	public void setMethodParams(String methodParams) {
		this.methodParams = methodParams;
	}

	public String getMisfirePolicy() {
		return misfirePolicy;
	}

	public void setMisfirePolicy(String misfirePolicy) {
		this.misfirePolicy = misfirePolicy;
	}

	public String getExecuteClass() {
		return executeClass;
	}

	public void setExecuteClass(String executeClass) {
		this.executeClass = executeClass;
	}
}