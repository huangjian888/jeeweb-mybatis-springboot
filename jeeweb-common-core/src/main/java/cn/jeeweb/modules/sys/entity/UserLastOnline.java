package cn.jeeweb.modules.sys.entity;

import cn.jeeweb.core.common.entity.DataEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**
 * @Title: 最后在线情况
 * @Description: 最后在线情况
 * @author jeeweb
 * @date 2017-05-15 08:18:21
 * @version V1.0
 *
 */
@TableName("sys_user_last_online")
@SuppressWarnings("serial")
public class UserLastOnline extends DataEntity<Long> {

	/** login_count */
	@TableField(value = "login_count")
	private Long loginCount;
	/** total_online_time */
	@TableField(value = "total_online_time")
	private Long totalOnlineTime;
	/** host */
	@TableField(value = "host")
	private String host;
	/** user_agent */
	@TableField(value = "user_agent")
	private String userAgent;
	/** system_host */
	@TableField(value = "system_host")
	private String systemHost;
	/** username */
	@TableField(value = "username")
	private String username;
	/** last_stop_timestamp */
	@TableField(value = "last_stop_timestamp")
	private Date lastStopTimestamp;
	/** last_login_timestamp */
	@TableField(value = "last_login_timestamp")
	private Date lastLoginTimestamp;
	/** uid */
	@TableField(value = "uid")
	private String uid;
	/** id */
	@TableId(value = "id", type = IdType.UUID)
	private Long id;
	/** user_id */
	@TableField(value = "user_id")
	private Long userId;

	/**
	 * 获取 loginCount
	 * 
	 * @return: Long login_count
	 */
	public Long getLoginCount() {
		return this.loginCount;
	}

	/**
	 * 设置 loginCount
	 * 
	 * @param: loginCount
	 *             login_count
	 */
	public void setLoginCount(Long loginCount) {
		this.loginCount = loginCount;
	}

	/**
	 * 获取 totalOnlineTime
	 * 
	 * @return: Long total_online_time
	 */
	public Long getTotalOnlineTime() {
		return this.totalOnlineTime;
	}

	/**
	 * 设置 totalOnlineTime
	 * 
	 * @param: totalOnlineTime
	 *             total_online_time
	 */
	public void setTotalOnlineTime(Long totalOnlineTime) {
		this.totalOnlineTime = totalOnlineTime;
	}

	/**
	 * 获取 host
	 * 
	 * @return: String host
	 */
	public String getHost() {
		return this.host;
	}

	/**
	 * 设置 host
	 * 
	 * @param: host
	 *             host
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * 获取 userAgent
	 * 
	 * @return: String user_agent
	 */
	public String getUserAgent() {
		return this.userAgent;
	}

	/**
	 * 设置 userAgent
	 * 
	 * @param: userAgent
	 *             user_agent
	 */
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	/**
	 * 获取 systemHost
	 * 
	 * @return: String system_host
	 */
	public String getSystemHost() {
		return this.systemHost;
	}

	/**
	 * 设置 systemHost
	 * 
	 * @param: systemHost
	 *             system_host
	 */
	public void setSystemHost(String systemHost) {
		this.systemHost = systemHost;
	}

	/**
	 * 获取 username
	 * 
	 * @return: String username
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * 设置 username
	 * 
	 * @param: username
	 *             username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取 lastStopTimestamp
	 * 
	 * @return: Date last_stop_timestamp
	 */
	public Date getLastStopTimestamp() {
		return this.lastStopTimestamp;
	}

	/**
	 * 设置 lastStopTimestamp
	 * 
	 * @param: lastStopTimestamp
	 *             last_stop_timestamp
	 */
	public void setLastStopTimestamp(Date lastStopTimestamp) {
		this.lastStopTimestamp = lastStopTimestamp;
	}

	/**
	 * 获取 lastLoginTimestamp
	 * 
	 * @return: Date last_login_timestamp
	 */
	public Date getLastLoginTimestamp() {
		return this.lastLoginTimestamp;
	}

	/**
	 * 设置 lastLoginTimestamp
	 * 
	 * @param: lastLoginTimestamp
	 *             last_login_timestamp
	 */
	public void setLastLoginTimestamp(Date lastLoginTimestamp) {
		this.lastLoginTimestamp = lastLoginTimestamp;
	}

	/**
	 * 获取 uid
	 * 
	 * @return: String uid
	 */
	public String getUid() {
		return this.uid;
	}

	/**
	 * 设置 uid
	 * 
	 * @param: uid
	 *             uid
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * 获取 id
	 * 
	 * @return: Long id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * 设置 id
	 * 
	 * @param: id
	 *             id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取 userId
	 * 
	 * @return: Long user_id
	 */
	public Long getUserId() {
		return this.userId;
	}

	/**
	 * 设置 userId
	 * 
	 * @param: userId
	 *             user_id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
