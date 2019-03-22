package com.company.manerger.sys.common.utils;


public abstract class ObjectSwitchHelper {

	public void setString(String key, String value) {
		set(key, value);
	}

	public void setInt(String key, int value) {
		setString(key, String.valueOf(value));
	}

	public void setBoolean(String key, Boolean value) {
		setString(key, String.valueOf(value));
	}

	public void setByte(String key, byte[] value) {
		setString(key, String.valueOf(value));
	}

	public void setShort(String key, short value) {

		setString(key, String.valueOf(value));
	}

	public void setLong(String key, long value) {

		setString(key, String.valueOf(value));
	}

	public void setFloat(String key, float value) {
		setString(key, String.valueOf(value));
	}

	public void setDouble(String key, double value) {
		setString(key, String.valueOf(value));
	}

	public String getString(String key) {
		if (get(key)==null) {
			return "";
		}
		return String.valueOf(get(key));
	}

	public int getInt(String key) {
		return Integer.valueOf(getString(key));
	}

	public boolean getBoolean(String key) {
		return Boolean.valueOf(getString(key));
	}

	public byte[] getByte(String key) {
		return getString(key).getBytes();
	}

	public short getShort(String key) {
		return Short.valueOf(getString(key, ""));
	}

	public long getLong(String key) {
		return Long.valueOf(getString(key));
	}

	public float getFloat(String key) {
		return Float.valueOf(getString(key));
	}

	public double getDouble(String key) {
		return Double.valueOf(getString(key));
	}

	public String getString(String key, String defaultValue) {
		return get(key) != null&&!StringUtils.isEmpty((String) get(key)) ? String.valueOf(get(key)) : defaultValue;
	}

	public int getInt(String key, int defaultValue) {
		try {
			return Integer.valueOf(getString(key, ""));
		} catch (Exception e) {

		}
		return defaultValue;
	}

	public boolean getBoolean(String key, Boolean defaultValue) {
		try {
			return Boolean.valueOf(getString(key, ""));
		} catch (Exception e) {

		}
		return defaultValue;
	}

	public byte[] getByte(String key, byte[] defaultValue) {
		try {
			return getString(key, "").getBytes();
		} catch (Exception e) {

		}
		return defaultValue;
	}

	public short getShort(String key, Short defaultValue) {
		try {
			return Short.valueOf(getString(key, ""));
		} catch (Exception e) {

		}
		return defaultValue;
	}

	public long getLong(String key, Long defaultValue) {

		try {
			return Long.valueOf(getString(key, ""));
		} catch (Exception e) {

		}
		return defaultValue;
	}

	public float getFloat(String key, Float defaultValue) {

		try {
			return Float.valueOf(getString(key, ""));
		} catch (Exception e) {

		}
		return defaultValue;
	}

	public double getDouble(String key, Double defaultValue) {
		try {
			return Double.valueOf(getString(key, ""));
		} catch (Exception e) {

		}
		return defaultValue;
	}

	public void remove(String... keys) {
		for (String key : keys) {
			remove(key);
		}
	}

	public abstract Object get(String key);

	public abstract void set(String key, Object value);

	public abstract boolean remove(String key);

}
