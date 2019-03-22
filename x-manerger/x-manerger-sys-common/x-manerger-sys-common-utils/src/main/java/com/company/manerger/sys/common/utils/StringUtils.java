package com.company.manerger.sys.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringEscapeUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils extends org.apache.commons.lang3.StringUtils {
	private static final String CHARSET_NAME = "UTF-8";

	/**
	 * 转换为字节数组
	 * @param str
	 * @return
	 */
	public static byte[] getBytes(String str){
		if (str != null){
			try {
				return str.getBytes(CHARSET_NAME);
			} catch (UnsupportedEncodingException e) {
				return null;
			}
		}else{
			return null;
		}
	}



	// 首字母转小写
	public static String toLowerCaseFirstOne(String s) {
		if (Character.isLowerCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
	}

	// 首字母转大写
	public static String toUpperCaseFirstOne(String s) {

		if (Character.isUpperCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
	}

	/**
	 * 判断是否是空字符串 null和"" 都返回 true
	 *
	 * @author Robin Chang
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(String s) {
		if (s != null && !s.equals("")) {
			return false;
		}
		return true;
	}

	public static void printJson(HttpServletResponse response, Object content) {
		try {
			//response.reset();
			response.setContentType("application/json");
			//response.setHeader("Cache-Control", "no-store");
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			String json = JSONObject.toJSONString(content);
			pw.print(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void printJson(HttpServletResponse response, String content) {
		try {
			//response.reset();
			response.setContentType("application/json");
			//response.setHeader("Cache-Control", "no-store");
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			pw.write(content);
			pw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 判断是否为数字
	 *
	 * @Title: isNumeric
	 * @Description: 判断是否为数字
	 * @param str
	 * @return
	 * @return: boolean
	 */
	public static boolean isNumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 *
	 * @title: camelToUnderline
	 * @description: 驼峰转下划线
	 * @param param
	 * @return
	 * @return: String
	 */
	public static String camelToUnderline(String param) {
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		int len = param.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (Character.isUpperCase(c)) {
				sb.append('_');
				sb.append(Character.toLowerCase(c));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 *
	 * @title: underlineToCamel
	 * @description:下划线转驼峰
	 * @param param
	 * @return
	 * @return: String
	 */
	public static String underlineToCamel(String param) {
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		int len = param.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (c == '_') {
				if (++i < len) {
					sb.append(Character.toUpperCase(param.charAt(i)));
				}
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 *
	 * @title: camelToUnderline
	 * @description: 驼峰转下划线
	 * @param param
	 * @return
	 * @return: String
	 */
	public static String camelToStrikethrough(String param) {
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		int len = param.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (Character.isUpperCase(c)) {
				sb.append('-');
				sb.append(Character.toLowerCase(c));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 *
	 * @title: underlineToCamel
	 * @description:下划线转驼峰
	 * @param param
	 * @return
	 * @return: String
	 */
	public static String strikethroughToCamel(String param) {
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		int len = param.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (c == '_') {
				if (++i < len) {
					sb.append(Character.toUpperCase(param.charAt(i)));
				}
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * A hashing method that changes a string (like a URL) into a hash suitable
	 * for using as a disk filename.
	 */
	public static String hashKeyForDisk(String key) {
		String cacheKey;
		try {
			final MessageDigest mDigest = MessageDigest.getInstance("MD5");
			mDigest.update(key.getBytes());
			cacheKey = bytesToHexString(mDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			cacheKey = String.valueOf(key.hashCode());
		}
		return cacheKey;
	}

	public static String bytesToHexString2(byte[] src){
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	private static String bytesToHexString(byte[] bytes) {
		// http://stackoverflow.com/questions/332079
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(0xFF & bytes[i]);
			if (hex.length() == 1) {
				sb.append('0');
			}
			sb.append(hex);
		}
		return sb.toString();
	}

	/**
	 *
	 * @title: getExtensionName
	 * @description: Java文件操作 获取文件扩展名
	 * @param filename
	 * @return
	 * @return: String
	 */
	public static String getExtensionName(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int dot = filename.lastIndexOf('.');
			if ((dot > -1) && (dot < (filename.length() - 1))) {
				return filename.substring(dot + 1);
			}
		}
		return filename;
	}

	/**
	 *
	 * @title: getFileNameNoEx
	 * @description: Java文件操作 获取不带扩展名的文件名
	 * @param filename
	 * @return
	 * @return: String
	 */
	public static String getFileNameNoEx(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int dot = filename.lastIndexOf('.');
			if ((dot > -1) && (dot < (filename.length()))) {
				return filename.substring(0, dot);
			}
		}
		return filename;
	}

	public static String randomUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}

	public static String randomString(int length) { //length表示生成字符串的长度
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	public static String randomNumber(int length) { //length表示生成字符串的长度
		String base = "0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	public static boolean isNumericAndDot(String str) {
		if (str == null || str.trim().equals("")) {
			return false;
		}
		Pattern pattern = Pattern.compile("-?[0-9]+.?[0-9]*([Ee]{1}[0-9]+)?");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	/**
	 * 去除字符串首尾出现的某个字符.
	 *
	 * @param source
	 *            源字符串.
	 * @param element
	 *            需要去除的字符.
	 * @return String.
	 */
	public static String trimFirstAndLastChar(String source, char element) {
		boolean beginIndexFlag = true;
		boolean endIndexFlag = true;
		do {
			int beginIndex = source.indexOf(element) == 0 ? 1 : 0;
			int endIndex = source.lastIndexOf(element) + 1 == source.length() ? source.lastIndexOf(element)
					: source.length();
			source = source.substring(beginIndex, endIndex);
			beginIndexFlag = (source.indexOf(element) == 0);
			endIndexFlag = (source.lastIndexOf(element) + 1 == source.length());
		} while (beginIndexFlag || endIndexFlag);
		return source;
	}

	/**
	 * 缩略字符串（不区分中英文字符）
	 *
	 * @param str
	 *            目标字符串
	 * @param length
	 *            截取长度
	 * @return
	 */
	public static String abbr(String str, int length) {
		if (str == null) {
			return "";
		}
		try {
			StringBuilder sb = new StringBuilder();
			int currentLength = 0;
			for (char c : replaceHtml(StringEscapeUtils.unescapeHtml4(str)).toCharArray()) {
				currentLength += String.valueOf(c).getBytes("GBK").length;
				if (currentLength <= length - 3) {
					sb.append(c);
				} else {
					sb.append("...");
					break;
				}
			}
			return sb.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 替换掉HTML标签方法
	 */
	public static String replaceHtml(String html) {
		if (isBlank(html)) {
			return "";
		}
		String regEx = "<.+?>";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(html);
		String s = m.replaceAll("");
		return s;
	}

	public static <T> String toFormatterValue(List<T> datas, String label, String value) {
		String formaterValues = "";
		for (Object data : datas) {
			if (!StringUtils.isEmpty(formaterValues)) {
				formaterValues+=";";
			}
			String labelValue = Reflections.getFieldValue(data, label) + "";
			String valueValue = Reflections.getFieldValue(data, value) + "";
			String formaterValue = valueValue + ":" + labelValue;
			formaterValues+=formaterValue;
		}
		return formaterValues;
	}


	/**
	 * 转换为字节数组
	 * @param bytes
	 * @return
	 */
	public static String toString(byte[] bytes){
		try {
			return new String(bytes, CHARSET_NAME);
		} catch (UnsupportedEncodingException e) {
			return EMPTY;
		}
	}

	/**

	 * 判断字符串是否是乱码
	 *
	 * @param strName 字符串
	 * @return 是否是乱码
	 */
	public static boolean isMessyCode(String strName) {
		try {
			Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");
			Matcher m = p.matcher(strName);
			String after = m.replaceAll("");
			String temp = after.replaceAll("\\p{P}", "");
			char[] ch = temp.trim().toCharArray();
			int length = (ch != null) ? ch.length : 0;
			for (int i = 0; i < length; i++) {
				char c = ch[i];
				if (!Character.isLetterOrDigit(c)) {
					String str = "" + ch[i];
					if (!str.matches("[\u4e00-\u9fa5]+")) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 去掉前面的下划线
	 * @param filename
	 * @return
	 */
	public static String trimDiagonal(String filename){
		if (filename.startsWith("/")) {
			filename = filename.substring(1, filename.length());
			//下一次
			return trimDiagonal(filename);
		}else{
			return filename;
		}
	}


}
