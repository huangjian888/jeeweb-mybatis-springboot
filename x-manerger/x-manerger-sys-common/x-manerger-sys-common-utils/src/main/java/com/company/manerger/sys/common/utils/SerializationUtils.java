package com.company.manerger.sys.common.utils;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.io.Serializable;

/**
 * 序列化工具
 */
public class SerializationUtils extends org.apache.commons.lang3.SerializationUtils {

	public static String serializeStr(final Serializable object) {
		if (object == null) {
			return null;
		}
		byte[] objectBytes = serialize(object);
		String hexStr = Hex.encodeHexString(objectBytes);
		return hexStr;
	}

	public static Object deserializeStr(String hexStr) {
		try {
			if (StringUtils.isEmpty(hexStr)) {
				return null;
			}
			return deserialize(Hex.decodeHex(hexStr.toCharArray()));
		} catch (DecoderException e) {
			e.printStackTrace();
		}
		return null;
	}

}