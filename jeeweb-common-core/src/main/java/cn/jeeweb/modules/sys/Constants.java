package cn.jeeweb.modules.sys;

public class Constants {
	// 字典缓存KEY
	public static final String CACHE_DICT_MAP = "cacheDictMap";
	public static final String CURRENT_USER = "systemuser";
	public static final String CURRENT_USERNAME = "systemusername";
	public static final String SESSION_FORCE_LOGOUT_KEY = "session.force.logout";

	public static final String ERROR = "error";
	public static final String SUCCESS = "error";
	public static final String MESSAGE = "message";

	/** 缓存命名空间 */
	public static final String CACHE_NAMESPACE = "jeeweb:";
	public static final String SYSTEM_CACHE_NAMESPACE = "s:jeeweb:";
	public static final String REDIS_SHIRO_CACHE = SYSTEM_CACHE_NAMESPACE + "shiro-cache:";
	public static final String REDIS_SHIRO_SESSION = SYSTEM_CACHE_NAMESPACE + "shiro-session:";
	public static final String REDIS_TOKEN = SYSTEM_CACHE_NAMESPACE + "token:";

	/** 在线用户数量 */
	public static final String ALLUSER_NUMBER = SYSTEM_CACHE_NAMESPACE + "ALLUSER_NUMBER";
}
