package cn.jeeweb.modules.common.bean;

/**
 * 重复验证
 * 
 * @author auth_team
 *
 */
@SuppressWarnings("serial")
public class DuplicateValid implements java.io.Serializable {

	/**
	 * 字段名
	 */
	private String name;

	/**
	 * 字段值
	 */
	private String param;

	/**
	 * 字段名
	 */
	private String extendName;

	/**
	 * 字段值
	 */
	private String extendParam;
	/**
	 * 查询方式
	 */
	private String queryType;
	/**
	 * 查询的DATA
	 */
	private String queryData;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public String getQueryData() {
		return queryData;
	}

	public void setQueryData(String queryData) {
		this.queryData = queryData;
	}

	public String getExtendName() {
		return extendName;
	}

	public void setExtendName(String extendName) {
		this.extendName = extendName;
	}

	public String getExtendParam() {
		return extendParam;
	}

	public void setExtendParam(String extendParam) {
		this.extendParam = extendParam;
	}

}