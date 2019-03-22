package com.company.manerger.sys.common.utils.mapper;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 绑定JSON/自定义 数据到 Map
 */
public class MapWapper<K, V> {

	private Map<K, V> innerMap = new HashMap<K, V>();

	public void setInnerMap(Map<K, V> innerMap) {
		this.innerMap = innerMap;
	}

	public Map<K, V> getInnerMap() {
		return innerMap;
	}

	public void clear() {
		innerMap.clear();
	}

	public boolean containsKey(Object key) {
		return innerMap.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return innerMap.containsValue(value);
	}

	public Set<Map.Entry<K, V>> entrySet() {
		return innerMap.entrySet();
	}

	public boolean equals(Object o) {
		return innerMap.equals(o);
	}

	public V get(Object key) {
		return innerMap.get(key);
	}

	public int hashCode() {
		return innerMap.hashCode();
	}

	public boolean isEmpty() {
		return innerMap.isEmpty();
	}

	public Set<K> keySet() {
		return innerMap.keySet();
	}

	public V put(K key, V value) {
		return innerMap.put(key, value);
	}

	public void putAll(Map<? extends K, ? extends V> m) {
		innerMap.putAll(m);
	}

	public V remove(Object key) {
		return innerMap.remove(key);
	}

	public int size() {
		return innerMap.size();
	}

	public Collection<V> values() {
		return innerMap.values();
	}

	public Map<K, V> toMap() {
		return innerMap;
	}

	@Override
	public String toString() {
		return innerMap.toString();
	}

}
