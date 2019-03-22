package com.company.manerger.sys.service.modules.sys.entity;

import com.company.manerger.sys.common.utils.SerializationUtils;
import com.company.manerger.sys.service.common.entity.DataEntity;
import com.company.manerger.sys.service.security.shiro.session.mgt.OnlineSession;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;

/**
 *
 * @description: 当前在线会话
 *
 */
@SuppressWarnings("serial")
public class UserOnline extends DataEntity<String> {

	/**
	 * 用户会话id ===> uid
	 */
	private String id;

	// 当前登录的用户Id
	private String userId;

	private String username;

	/**
	 * 用户主机地址
	 */
	private String host;

	/**
	 * 用户登录时系统IP
	 */
	private String systemHost;

	/**
	 * 用户浏览器类型
	 */
	@TableField(value = "user_agent")
	private String userAgent;

	/**
	 * 在线状态
	 */
	private String status = "on_line";

	/**
	 * session创建时间
	 */
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date startTimestamp;
	/**
	 * session最后访问时间
	 */
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date lastAccessTime;

	/**
	 * 超时时间
	 */
	private Long timeout;

	/**
	 * 备份的当前用户会话
	 */
	private String onlineSession;

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
