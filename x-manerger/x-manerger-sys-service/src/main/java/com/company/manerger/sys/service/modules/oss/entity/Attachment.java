package com.company.manerger.sys.service.modules.oss.entity;

import com.company.manerger.sys.service.common.entity.DataEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;

/**
 * @description: 附件实体
 */

@TableName("oss_attachment")
@SuppressWarnings("serial")
public class Attachment extends DataEntity<String>{

    /**id*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**文件名称*/
    @TableField(value = "file_name")
	private String fileName;
    /**用户ID*/
    @TableField(value = "user_id")
	private String userId;
    /**上传时间*/
    @TableField(value = "upload_time")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date uploadTime;
    /**上传的ID*/
    @TableField(value = "upload_ip")
	private String uploadIp;
    /**文件扩展名*/
    @TableField(value = "file_extension")
	private String fileExtension;
    /**文件路径*/
    @TableField(value = "file_path")
	private String filePath;
    /**文件大小*/
    @TableField(value = "file_size")
	private Long fileSize;
    /**content_type*/
    @TableField(value = "content_type")
	private String contentType;
    /**状态*/
    @TableField(value = "status")
	private String status;
    /**oss的根路径*/
    @TableField(value = "base_path")
	private String basePath;

	/**
	 * 获取  id
	 *@return String  id
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * 设置  id
	 *@param id  id
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * 获取  fileName
	 *@return String  文件名称
	 */
	public String getFileName(){
		return this.fileName;
	}

	/**
	 * 设置  fileName
	 *@param fileName  文件名称
	 */
	public void setFileName(String fileName){
		this.fileName = fileName;
	}
	/**
	 * 获取  userId
	 *@return String  用户ID
	 */
	public String getUserId(){
		return this.userId;
	}

	/**
	 * 设置  userId
	 *@param userId  用户ID
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	/**
	 * 获取  uploadTime
	 *@return Date  上传时间
	 */
	public Date getUploadTime(){
		return this.uploadTime;
	}

	/**
	 * 设置  uploadTime
	 *@param uploadTime  上传时间
	 */
	public void setUploadTime(Date uploadTime){
		this.uploadTime = uploadTime;
	}
	/**
	 * 获取  uploadIp
	 *@return String  上传的ID
	 */
	public String getUploadIp(){
		return this.uploadIp;
	}

	/**
	 * 设置  uploadIp
	 *@param uploadIp  上传的ID
	 */
	public void setUploadIp(String uploadIp){
		this.uploadIp = uploadIp;
	}
	/**
	 * 获取  fileExtension
	 *@return String  文件扩展名
	 */
	public String getFileExtension(){
		return this.fileExtension;
	}

	/**
	 * 设置  fileExtension
	 *@param fileExtension  文件扩展名
	 */
	public void setFileExtension(String fileExtension){
		this.fileExtension = fileExtension;
	}
	/**
	 * 获取  filePath
	 *@return String  文件路径
	 */
	public String getFilePath(){
		return this.filePath;
	}

	/**
	 * 设置  filePath
	 *@param filePath  文件路径
	 */
	public void setFilePath(String filePath){
		this.filePath = filePath;
	}
	/**
	 * 获取  fileSize
	 *@return Integer  文件大小
	 */
	public Long getFileSize(){
		return this.fileSize;
	}

	/**
	 * 设置  fileSize
	 *@param fileSize  文件大小
	 */
	public void setFileSize(Long fileSize){
		this.fileSize = fileSize;
	}
	/**
	 * 获取  contentType
	 *@return String  content_type
	 */
	public String getContentType(){
		return this.contentType;
	}

	/**
	 * 设置  contentType
	 *@param contentType  content_type
	 */
	public void setContentType(String contentType){
		this.contentType = contentType;
	}
	/**
	 * 获取  status
	 *@return String  状态
	 */
	public String getStatus(){
		return this.status;
	}

	/**
	 * 设置  status
	 *@param status  状态
	 */
	public void setStatus(String status){
		this.status = status;
	}
	/**
	 * 获取  basePath
	 *@return String  oss的根路径
	 */
	public String getBasePath(){
		return this.basePath;
	}

	/**
	 * 设置  basePath
	 *@param basePath  oss的根路径
	 */
	public void setBasePath(String basePath){
		this.basePath = basePath;
	}
}