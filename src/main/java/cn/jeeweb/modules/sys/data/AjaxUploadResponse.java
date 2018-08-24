
package cn.jeeweb.modules.sys.data;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 
 * All rights Reserved, Designed By www.jeeweb.cn
 * 
 * @title: AjaxUploadResponse.java
 * @package cn.jeeweb.modules.sys.data
 * @description: 文件上传响应
 * @author: auth_team
 * @date: 2017年5月22日 下午9:23:14
 * @version V1.0
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *
 */
public class AjaxUploadResponse {

	private List<FileMeta> files = Lists.newArrayList();

	public void add(String name, long size, String error) {
		files.add(new FileMeta(name, size, error));
	}

	public void add(String name, long size, String url, String delete_url) {
		files.add(new FileMeta(name, size, url, delete_url));
	}

	public void add(String name, long size, String url, String thumbnail_url, String delete_url) {
		files.add(new FileMeta(name, size, url, thumbnail_url, delete_url));
	}

	public List<FileMeta> getFiles() {
		return files;
	}

	public void setFiles(List<FileMeta> files) {
		this.files = files;
	}

	/**
	 * 文件信息
	 */
	public static class FileMeta {

		/**
		 * 名称
		 */
		private String name = "";
		/**
		 * 大小
		 */
		private long size;

		/**
		 * 错误信息
		 */
		private String error = "";
		/**
		 * 上传文件后的地址
		 */
		private String url = "";
		/**
		 * 缩略图
		 */
		private String thumbnail_url = "";
		/**
		 * 删除时的URL
		 */
		private String delete_url = "";
		private String delete_type = "POST";

		public FileMeta(String name, long size, String url, String thumbnail_url, String delete_url) {
			this.name = name;
			this.size = size;
			this.url = url;
			this.thumbnail_url = thumbnail_url;
			this.delete_url = delete_url;
		}

		public FileMeta(String name, long size, String url, String delete_url) {
			this.name = name;
			this.size = size;
			this.url = url;
			this.delete_url = delete_url;
		}

		public FileMeta(String name, long size, String error) {
			this.name = name;
			this.error = error;
			this.size = size;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public long getSize() {
			return size;
		}

		public void setSize(long size) {
			this.size = size;
		}

		public String getError() {
			return error;
		}

		public void setError(String error) {
			this.error = error;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getThumbnail_url() {
			return thumbnail_url;
		}

		public void setThumbnail_url(String thumbnail_url) {
			this.thumbnail_url = thumbnail_url;
		}

		public String getDelete_url() {
			return delete_url;
		}

		public void setDelete_url(String delete_url) {
			this.delete_url = delete_url;
		}

		public String getDelete_type() {
			return delete_type;
		}

		public void setDelete_type(String delete_type) {
			this.delete_type = delete_type;
		}
	}

}
