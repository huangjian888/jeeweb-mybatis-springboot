package cn.jeeweb.modules.sys.entity;

import cn.jeeweb.core.common.entity.AbstractEntity;
import cn.jeeweb.core.utils.StringUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;
import java.util.Map;

@TableName("sys_log")
@SuppressWarnings("serial")
public class Log extends AbstractEntity<String> {

	// 日志类型（1：接入日志；2：错误日志）
	public static final String TYPE_ACCESS = "1";
	public static final String TYPE_EXCEPTION = "2";

	/** 编号 */
	@TableId(value = "id", type = IdType.UUID)
	private String id;
	/** 用户代理 */
	private String userAgent;
	/** 请求URI */
	private String requestUri;
	/** 日志标题 */
	private String title;
	/** 日志类型 */
	private String type;
	/** 操作方式 */
	private String method;
	/** 异常信息 */
	private String exception;
	/** 日志内容 */
	private String content;
	/** 操作方式 */
	private String logtype;
	/** 操作提交的数据 */

	private String params;
	/** 操作IP地址 */
	private String remoteAddr;
	/** 创建者 */
	@TableField(value = "create_by", el = "createBy.id", fill = FieldFill.INSERT)
	private User createBy;
	/** 创建时间 */
	@TableField(value = "create_date", fill = FieldFill.INSERT)
	private Date createDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getRequestUri() {
		return requestUri;
	}

	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLogtype() {
		return logtype;
	}

	public void setLogtype(String logtype) {
		this.logtype = logtype;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	/**
	 * 设置请求参数
	 * 
	 * @param paramMap
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setParams(Map paramMap) {
		if (paramMap == null) {
			return;
		}
		StringBuilder params = new StringBuilder();
		for (Map.Entry<String, String[]> param : ((Map<String, String[]>) paramMap).entrySet()) {
			params.append(("".equals(params.toString()) ? "" : "&") + param.getKey() + "=");
			String paramValue = (param.getValue() != null && param.getValue().length > 0 ? param.getValue()[0] : "");
			params.append(StringUtils.abbr(StringUtils.endsWithIgnoreCase(param.getKey(), "password") ? "" : paramValue,
					100));
		}
		this.params = params.toString();
	}

	public String getRemoteAddr() {
		return remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	public User getCreateBy() {
		return createBy;
	}

	public void setCreateBy(User createBy) {
		this.createBy = createBy;
	}

}
