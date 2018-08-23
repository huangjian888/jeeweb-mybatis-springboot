package cn.jeeweb.modules.oa.entity;

import cn.jeeweb.core.common.entity.DataEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * @Title: 通知公告
 * @Description: 通知公告
 * @author jeeweb
 * @date 2017-06-10 17:15:17
 * @version V1.0
 *
 */
@TableName("oa_notification")
@SuppressWarnings("serial")
public class OaNotification extends DataEntity<String> {

	/** 字段主键 */
	@TableId(value = "id", type = IdType.UUID)
	private String id;
	/** 标题 */
	private String title;
	/** 内容 */
	private String content;
	/** 发布状态 */
	private String status;

	/**
	 * 获取 id
	 * 
	 * @return: String 字段主键
	 */

	public String getId() {
		return this.id;
	}

	/**
	 * 设置 id
	 * 
	 * @param: id
	 *             字段主键
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取 title
	 * 
	 * @return: String 标题
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * 设置 title
	 * 
	 * @param: title
	 *             标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 获取 content
	 * 
	 * @return: Text 内容
	 */
	public String getContent() {
		return this.content;
	}

	/**
	 * 设置 content
	 * 
	 * @param: content
	 *             内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 获取 status
	 * 
	 * @return: String 发布状态
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * 设置 status
	 * 
	 * @param: status
	 *             发布状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
