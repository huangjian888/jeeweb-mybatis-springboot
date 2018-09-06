package cn.jeeweb.modules.common.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ValidJson implements Serializable {
	private String status;
	private String info;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
