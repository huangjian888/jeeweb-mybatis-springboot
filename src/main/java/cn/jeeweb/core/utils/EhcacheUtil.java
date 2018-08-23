package cn.jeeweb.core.utils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * 缓存基础类
 * 
 * @author auth_team
 * @version 2017-01-19
 */
public class EhcacheUtil extends ObjectSwitchHelper {

	private static CacheManager manager = ((CacheManager) SpringContextHolder.getBean("ehcacheManager"));
	private Cache cache = null;

	public EhcacheUtil() {

	}

	public EhcacheUtil(String cacheName) {
		load(cacheName);
	}

	/**
	 * 加载缓存
	 * 
	 * @param cacheName
	 */
	public void load(String cacheName) {
		cache = manager.getCache(cacheName);
	}

	@Override
	public Object get(String key) {
		if (cache != null) {
			Element element = cache.get(key);
			if (element != null) {
				return element.getObjectValue();
			}
		}
		return null;
	}

	@Override
	public void set(String key, Object value) {
		if (cache != null) {
			cache.put(new Element(key, value));
		}
	}

	@Override
	public boolean remove(String key) {
		if (cache != null) {
			return cache.remove(key);
		}
		return false;
	}
    /**
     * 
     * @title: removeAll   
     * @description: 清楚所有緩存    
     * @return: void
     */
	public void removeAll() {
		if (cache != null) {
			cache.removeAll();
		}
	}

	public static void main(String[] args) {
		String key = "key";
		String value = "1";
		EhcacheUtil ehcacheUtil = new EhcacheUtil("syscommoncache");
		ehcacheUtil.set(key, value);
		ehcacheUtil.remove(key);
		System.out.println(ehcacheUtil.getInt(key));
	}

}