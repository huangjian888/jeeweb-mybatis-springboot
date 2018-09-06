package cn.jeeweb.modules.sys.entity;

import cn.jeeweb.core.common.entity.DataEntity;
import cn.jeeweb.core.utils.SerializationUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**
 *
 * All rights Reserved, Designed By www.jeeweb.cn
 *
 * @title: UserOnline.java
 * @package cn.jeeweb.modules.sys.entity
 * @description: 当前在线会话
 * @author: auth_team
 * @date: 2017年7月3日 下午3:59:32
 * @version V1.0
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *
 */
@SuppressWarnings("serial")
@TableName("sys_user_online")
public class UserOnline extends DataEntity<String> {

	/**
	 * 用户会话id ===> uid
	 */
	@TableId(value = "id", type = IdType.INPUT)
	private String id;

	// 当前登录的用户Id
	@TableField(value = "user_id")
	private String userId;

	@TableField(value = "username")
	private String username;

	/**
	 * 用户主机地址
	 */
	@TableField(value = "host")
	private String host;

	/**
	 * 用户登录时系统IP
	 */
	@TableField(value = "system_host")
	private String systemHost;

	/**
	 * 用户浏览器类型
	 */
	@TableField(value = "user_agent")
	private String userAgent;

	/**
	 * 在线状态
	 */
	@TableField(value = "status")
	private String status = "on_line";

	/**
	 * session创建时间
	 */
	@TableField(value = "start_timestsamp")
	private Date startTimestamp;
	/**
	 * session最后访问时间
	 */
	@TableField(value = "last_access_time")
	private Date lastAccessTime;

	/**
	 * 超时时间
	 */
	@TableField(value = "online_timeout")
	private Long timeout;

	/**
	 * 备份的当前用户会话
	 */
	@TableField(value = "online_session")
	private String onlineSession;

	@TableField(exist = false)
	private OnlineSession session;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getStartTimestamp() {
		return startTimestamp;
	}

	public void setStartTimestamp(Date startTimestamp) {
		this.startTimestamp = startTimestamp;
	}

	public Date getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(Date lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	public Long getTimeout() {
		return timeout;
	}

	public void setTimeout(Long timeout) {
		this.timeout = timeout;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOnlineSession() {
		return onlineSession;
	}

	public void setOnlineSession(String onlineSession) {
		this.onlineSession = onlineSession;
	}

	public OnlineSession getSession() {
		if (this.session == null) {
			this.session = (OnlineSession) SerializationUtils.deserializeStr(this.onlineSession);
		}
		return this.session;
	}

	public void setSession(OnlineSession session) {
		this.session = session;
		this.onlineSession = SerializationUtils.serializeStr(session);
	}

	public String getSystemHost() {
		return systemHost;
	}

	public void setSystemHost(String systemHost) {
		this.systemHost = systemHost;
	}

	public static final UserOnline fromOnlineSession(OnlineSession session) {
		UserOnline online = new UserOnline();
		online.setId(String.valueOf(session.getId()));
		online.setUserId(session.getUserId());
		online.setUsername(session.getUsername());
		online.setStartTimestamp(session.getStartTimestamp());
		online.setLastAccessTime(session.getLastAccessTime());
		online.setTimeout(session.getTimeout());
		online.setHost(session.getHost());
		online.setUserAgent(session.getUserAgent());
		online.setSystemHost(session.getSystemHost());
		online.setSession(session);

		return online;
	}

}
