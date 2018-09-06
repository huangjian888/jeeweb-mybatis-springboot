package cn.jeeweb.core.utils.security;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {

	public String md5Digest(String src) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] b = md.digest(src.getBytes("utf-8"));
		return byte2HexStr(b);
	}

	public String base64Encoder(String src) throws UnsupportedEncodingException {
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(src.getBytes("utf-8"));
	}

	public String base64Decoder(String dest) throws NoSuchAlgorithmException, IOException {
		BASE64Decoder decoder = new BASE64Decoder();
		return new String(decoder.decodeBuffer(dest), "utf-8");
	}

	private String byte2HexStr(byte[] b) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < b.length; ++i) {
			String s = Integer.toHexString(b[i] & 0xFF);
			if (s.length() == 1)
				sb.append("0");

			sb.append(s.toUpperCase());
		}
		return sb.toString();
	}
}