package cn.jeeweb.modules.task.entity;

import cn.jeeweb.core.common.entity.AbstractEntity;
import cn.jeeweb.modules.sys.entity.User;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**
 * @Title: 任务
 * @Description: 任务
 * @author jeeweb
 * @date 2017-05-09 23:22:51
 * @version V1.0
 *
 */
@TableName("task_schedule_job")
@SuppressWarnings("serial")
public class ScheduleJob extends AbstractEntity<String> {

	/** 任务主键 */
	@TableId(value = "id", type = IdType.UUID)
	private String id;
	/** cron表达式 */
	@TableField(value = "cron_expression")
	private String cronExpression;
	/** 任务调用的方法名 */
	@TableField(value = "method_name")
	private String methodName;
	/** 任务是否有状态 */
	@TableField(value = "is_concurrent")
	private String isConcurrent;
	/** 任务描述 */
	@TableField(value = "description")
	private String description;
	/** 更新者 */
	@TableField(value = "update_by",el="updateBy.id")
	private User updateBy;
	/** 任务执行时调用哪个类的方法 包名+类名 */
	@TableField(value = "bean_class")
	private String beanClass;
	/** 创建时间 */
	@TableField(value = "create_date")
	private Date createDate;
	/** 任务状态 */
	@TableField(value = "job_status")
	private String jobStatus;
	/** 任务分组 */
	@TableField(value = "job_group")
	private String jobGroup;
	/** 更新时间 */
	@TableField(value = "update_date")
	private Date updateDate;
	/** 创建者 */
	@TableField(value = "create_by",el="createBy.id")
	private User createBy;
	/** Spring bean */
	@TableField(value = "spring_bean")
	private String springBean;
	/** 任务名 */
	@TableField(value = "job_name")
	private String jobName;

	/**
	 * 获取 cronExpression
	 * 
	 * @return: String cron表达式
	 */
	public String getCronExpression() {
		return this.cronExpression;
	}

	/**
	 * 设置 cronExpression
	 * 
	 * @param: cronExpression
	 *             cron表达式
	 */
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	/**
	 * 获取 methodName
	 * 
	 * @return: String 任务调用的方法名
	 */
	public String getMethodName() {
		return this.methodName;
	}

	/**
	 * 设置 methodName
	 * 
	 * @param: methodName
	 *             任务调用的方法名
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	/**
	 * 获取 isConcurrent
	 * 
	 * @return: String 任务是否有状态
	 */
	public String getIsConcurrent() {
		return this.isConcurrent;
	}

	/**
	 * 设置 isConcurrent
	 * 
	 * @param: isConcurrent
	 *             任务是否有状态
	 */
	public void setIsConcurrent(String isConcurrent) {
		this.isConcurrent = isConcurrent;
	}

	/**
	 * 获取 description
	 * 
	 * @return: String 任务描述
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * 设置 description
	 * 
	 * @param: description
	 *             任务描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 获取 id
	 * 
	 * @return: String 任务主键
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * 设置 id
	 * 
	 * @param: id
	 *             任务主键
	 */
	public void setId(String id) {
		this.id = id;
	}

	public User getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(User updateBy) {
		this.updateBy = updateBy;
	}

	public User getCreateBy() {
		return createBy;
	}

	public void setCreateBy(User createBy) {
		this.createBy = createBy;
	}

	/**
	 * 获取 beanClass
	 * 
	 * @return: String 任务执行时调用哪个类的方法 包名+类名
	 */
	public String getBeanClass() {
		return this.beanClass;
	}

	/**
	 * 设置 beanClass
	 * 
	 * @param: beanClass
	 *             任务执行时调用哪个类的方法 包名+类名
	 */
	public void setBeanClass(String beanClass) {
		this.beanClass = beanClass;
	}

	/**
	 * 获取 createDate
	 *
	 * @return: Date 创建时间
	 */
	public Date getCreateDate() {
		return this.createDate;
	}

	/**
	 * 设置 createDate
	 *
	 * @param: createDate
	 *             创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 获取 jobStatus
	 * 
	 * @return: String 任务状态
	 */
	public String getJobStatus() {
		return this.jobStatus;
	}

	/**
	 * 设置 jobStatus
	 * 
	 * @param: jobStatus
	 *             任务状态
	 */
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	/**
	 * 获取 jobGroup
	 * 
	 * @return: String 任务分组
	 */
	public String getJobGroup() {
		return this.jobGroup;
	}

	/**
	 * 设置 jobGroup
	 * 
	 * @param: jobGroup
	 *             任务分组
	 */
	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	/**
	 * 获取 updateDate
	 *
	 * @return: Date 更新时间
	 */
	public Date getUpdateDate() {
		return this.updateDate;
	}

	/**
	 * 设置 updateDate
	 *
	 * @param: updateDate
	 *             更新时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 获取 springBean
	 * 
	 * @return: String Spring bean
	 */
	public String getSpringBean() {
		return this.springBean;
	}

	/**
	 * 设置 springBean
	 * 
	 * @param: springBean
	 *             Spring bean
	 */
	public void setSpringBean(String springBean) {
		this.springBean = springBean;
	}

	/**
	 * 获取 jobName
	 * 
	 * @return: String 任务名
	 */
	public String getJobName() {
		return this.jobName;
	}

	/**
	 * 设置 jobName
	 * 
	 * @param: jobName
	 *             任务名
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

}
