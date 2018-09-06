package cn.jeeweb.core.model;

import java.util.LinkedHashMap;

public class AjaxJson {
	//200 OK - [GET]：服务器成功返回用户请求的数据，该操作是幂等的（Idempotent）。
	//201 CREATED - [POST/PUT/PATCH]：用户新建或修改数据成功。
	//202 Accepted - [*]：表示一个请求已经进入后台排队（异步任务）
	//204 NO CONTENT - [DELETE]：用户删除数据成功。
	//400 INVALID REQUEST - [POST/PUT/PATCH]：用户发出的请求有错误，服务器没有进行新建或修改数据的操作，该操作是幂等的。
	//401 Unauthorized - [*]：表示用户没有权限（令牌、用户名、密码错误）。
	//403 Forbidden - [*] 表示用户得到授权（与401错误相对），但是访问是被禁止的。
	//404 NOT FOUND - [*]：用户发出的请求针对的是不存在的记录，服务器没有进行操作，该操作是幂等的。
	//406 Not Acceptable - [GET]：用户请求的格式不可得（比如用户请求JSON格式，但是只有XML格式）。
	//410 Gone -[GET]：用户请求的资源被永久删除，且不会再得到的。
	//422 Unprocesable entity - [POST/PUT/PATCH] 当创建一个对象时，发生一个验证错误。
	//500 INTERNAL SERVER ERROR - [*]：服务器发生错误，用户将无法判断发出的请求是否成功。
	public final static int RET_SUCCESS = 0;
	public final static int RET_FAIL = -1;
	private int ret = 0;// 0: 正确返回。其它: 失败。
	// private int errorCode = 0;// 错误编码
	private String msg = "操作成功";// 提示信息
	private Object data = null;// 返回的数据
	private LinkedHashMap<String, Object> extend = new LinkedHashMap<String, Object>();// 扩展数据

	public void put(String key, Object value) {
		extend.put(key, value);
	}

	public void remove(String key) {
		extend.remove(key);
	}

	public LinkedHashMap<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(LinkedHashMap<String, Object> extend) {
		this.extend = extend;
	}

	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void success(String msg) {
		this.msg = msg;
		this.ret = AjaxJson.RET_SUCCESS;
	}

	public void fail(String msg) {
		this.msg = msg;
		this.ret = AjaxJson.RET_FAIL;
	}

}
