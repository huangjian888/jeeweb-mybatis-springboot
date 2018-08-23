package cn.jeeweb.modules.sys.entity;

import cn.jeeweb.core.common.entity.DataEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * @Title 用户实体
 * @Description:
 * @author auth_team
 * @date 2016-12-03 21:31:50
 * @version V1.0
 *
 */
@TableName("sys_user")
@SuppressWarnings("serial")
public class User extends DataEntity<String> {

	/**
	 * 是否锁定（1：正常；-1：删除；0：锁定；）
	 */
	public static final String STATUS_DELETE = "-1";
	public static final String STATUS_LOCKED = "0";
	public static final String STATUS_NORMAL = "1";

	/** id */
	@TableId(value = "id", type = IdType.UUID)
	private String id;
	// 姓名
	private String username;
	// 用户名
	private String realname;
	// 头像
	private String portrait;
	// 密码
	private String password;
	// 盐
	private String salt;
	// 邮件
	private String email;
	// 联系电话
	private String phone;

	/**
	 * 系统用户的状态
	 */
	private String status = STATUS_NORMAL;

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
	 * 获取 password
	 *
	 * @return: String password
	 */
	public String getPassword() {
		return this.password;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	/**
	 * 设置 password
	 *
	 * @param: password
	 *             password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取 id
	 *
	 * @return: String id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * 设置 id
	 *
	 * @param: id
	 *             id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取 salt
	 *
	 * @return: String salt
	 */
	public String getSalt() {
		return this.salt;
	}

	/**
	 * 设置 salt
	 *
	 * @param: salt
	 *             salt
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getCredentialsSalt() {
		return username + salt;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
