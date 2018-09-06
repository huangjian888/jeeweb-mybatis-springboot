package cn.jeeweb.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * @Title:
 * @Description:
 * @author jeeweb
 * @date 2017-02-21 12:54:43
 * @version V1.0
 *
 */
@TableName("sys_role_menu")
@SuppressWarnings("serial")
public class RoleMenu implements java.io.Serializable {

	/** 编号 */
	@TableId(value = "id", type = IdType.UUID)
	private String id;
	/** 菜单编号 */
	private String menuId;
	/** 角色编号 */
	private String roleId;

	/**
	 * 获取 id
	 * 
	 * @return: String 编号
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * 设置 id
	 * 
	 * @param: id
	 *             编号
	 */
	public void setId(String id) {
		this.id = id;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}
