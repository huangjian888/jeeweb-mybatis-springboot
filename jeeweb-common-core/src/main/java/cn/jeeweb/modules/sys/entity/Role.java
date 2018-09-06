package cn.jeeweb.modules.sys.entity;

import cn.jeeweb.core.common.entity.DataEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * @Title: 角色实体
 * @Description: 角色实体
 * @author auth_team
 * @date 2016-12-03 21:33:15
 * @version V1.0
 *
 */
@TableName("sys_role")
@SuppressWarnings("serial")
public class Role extends DataEntity<String> {
	@TableId(value = "id", type = IdType.UUID)
	private String id;
	@TableField(value = "name")
	private String name;// 角色名称
	@TableField(value = "code")
	private String code;// 角色编码
	@TableField(value = "is_sys")
	private String isSys;// 是否系统数据
	@TableField(value = "usable")
	private String usable;// 是否可用

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIsSys() {
		return isSys;
	}

	public void setIsSys(String isSys) {
		this.isSys = isSys;
	}

	public String getUsable() {
		return usable;
	}

	public void setUsable(String usable) {
		this.usable = usable;
	}

}
