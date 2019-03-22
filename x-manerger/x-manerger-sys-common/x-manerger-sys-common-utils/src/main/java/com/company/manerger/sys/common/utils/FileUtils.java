package com.company.manerger.sys.common.utils;

import java.io.*;

public class FileUtils extends org.apache.commons.io.FileUtils {
	// 验证字符串是否为正确路径名的正则表达式
	private static String matches = "[A-Za-z]:\\\\[^:?\"><*]*";
	boolean flag = false;
	File file;

	/**
	 * 传入路径，返回是否是绝对路径，是绝对路径返回true，反之
	 * 
	 * @param path
	 * @return
	 * @since 2015年4月21日
	 */
	public static boolean isAbsolutePath(String path) {
		if (path.startsWith("/") || path.indexOf(":") > 0) {
			return true;
		}
		return false;
	}

	public boolean deleteFolder(String deletePath) {// 根据路径删除指定的目录或文件，无论存在与否
		flag = false;
		if (deletePath.matches(matches)) {
			file = new File(deletePath);
			if (!file.exists()) {// 判断目录或文件是否存在
				return flag; // 不存在返回 false
			} else {

				if (file.isFile()) {// 判断是否为文件
					return deleteFile(deletePath);// 为文件时调用删除文件方法
				} else {
					return deleteDirectory(deletePath);// 为目录时调用删除目录方法
				}
			}
		} else {
			//System.out.println("要传入正确路径！");
			return false;
		}
	}

	public boolean deleteFile(String filePath) {// 删除单个文件
		flag = false;
		file = new File(filePath);
		if (file.isFile() && file.exists()) {// 路径为文件且不为空则进行删除
			file.delete();// 文件删除
			flag = true;
		}
		return flag;
	}

	public boolean deleteDirectory(String dirPath) {// 删除目录（文件夹）以及目录下的文件
		// 如果sPath不以文件分隔符结尾，自动添加文件分隔符
		if (!dirPath.endsWith(File.separator)) {
			dirPath = dirPath + File.separator;
		}
		File dirFile = new File(dirPath);
		// 如果dir对应的文件不存在，或者不是一个目录，则退出
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			return false;
		}
		flag = true;
		File[] files = dirFile.listFiles();// 获得传入路径下的所有文件
		for (int i = 0; i < files.length; i++) {// 循环遍历删除文件夹下的所有文件(包括子目录)
			if (files[i].isFile()) {// 删除子文件
				flag = deleteFile(files[i].getAbsolutePath());
				//System.out.println(files[i].getAbsolutePath() + " 删除成功");
				if (!flag)
					break;// 如果删除失败，则跳出
			} else {// 运用递归，删除子目录
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag)
					break;// 如果删除失败，则跳出
			}
		}
		if (!flag)
			return false;
		if (dirFile.delete()) {// 删除当前目录
			return true;
		} else {
			return false;
		}
	}

	// 创建单个文件
	public static boolean createFile(String filePath) {
		File file = new File(filePath);
		if (file.exists()) {// 判断文件是否存在
			//System.out.println("目标文件已存在" + filePath);
			return false;
		}
		if (filePath.endsWith(File.separator)) {// 判断文件是否为目录
			//System.out.println("目标文件不能为目录！");
			return false;
		}
		if (!file.getParentFile().exists()) {// 判断目标文件所在的目录是否存在
			// 如果目标文件所在的文件夹不存在，则创建父文件夹
			//System.out.println("目标文件所在目录不存在，准备创建它！");
			if (!file.getParentFile().mkdirs()) {// 判断创建目录是否成功
				//System.out.println("创建目标文件所在的目录失败！");
				return false;
			}
		}
		try {
			if (file.createNewFile()) {// 创建目标文件
				//System.out.println("创建文件成功:" + filePath);
				return true;
			} else {
				//System.out.println("创建文件失败！");
				return false;
			}
		} catch (IOException e) {// 捕获异常
			e.printStackTrace();
			//System.out.println("创建文件失败！" + e.getMessage());
			return false;
		}
	}

	// 创建临时文件
	public static String createTempFile(String prefix, String suffix, String dirName) {
		File tempFile = null;
		if (dirName == null) {// 目录如果为空
			try {
				tempFile = File.createTempFile(prefix, suffix);// 在默认文件夹下创建临时文件
				return tempFile.getCanonicalPath();// 返回临时文件的路径
			} catch (IOException e) {// 捕获异常
				e.printStackTrace();
				System.out.println("创建临时文件失败：" + e.getMessage());
				return null;
			}
		} else {
			// 指定目录存在
			File dir = new File(dirName);// 创建目录
			if (!dir.exists()) {
				// 如果目录不存在则创建目录
				if (FileUtils.mkDir(dirName)) {
					System.out.println("创建临时文件失败，不能创建临时文件所在的目录！");
					return null;
				}
			}
			try {
				tempFile = File.createTempFile(prefix, suffix, dir);// 在指定目录下创建临时文件
				return tempFile.getCanonicalPath();// 返回临时文件的路径
			} catch (IOException e) {// 捕获异常
				e.printStackTrace();
				System.out.println("创建临时文件失败!" + e.getMessage());
				return null;
			}
		}
	}

	/**
	 * 在指定的位置创建指定的文件
	 *
	 * @param filePath
	 *            完整的文件路径
	 * @param mkdir
	 *            是否创建相关的文件夹
	 * @throws Exception
	 */
	public static void mkFile(String filePath, boolean mkdir) throws Exception {
		File file = new File(filePath);
		file.getParentFile().mkdirs();
		file.createNewFile();
		file = null;
	}

	/**
	 * 在指定的位置创建文件夹
	 *
	 * @param dirPath
	 *            文件夹路径
	 * @return 若创建成功，则返回True；反之，则返回False
	 */
	public static boolean mkDir(String dirPath) {
		File dir = new File(dirPath);
		if (dir.exists()) {// 判断目录是否存在
			System.out.println("创建目录失败，目标目录已存在！");
			return false;
		}
		if (!dirPath.endsWith(File.separator)) {// 结尾是否以"/"结束
			dirPath = dirPath + File.separator;
		}
		if (dir.mkdirs()) {// 创建目标目录
			System.out.println("创建目录成功！" + dirPath);
			return true;
		} else {
			System.out.println("创建目录失败！");
			return false;
		}
	}

	/**
	 * 删除指定的文件
	 *
	 * @param filePath
	 *            文件路径
	 *
	 * @return 若删除成功，则返回True；反之，则返回False
	 *
	 */
	public static boolean delFile(String filePath) {
		return new File(filePath).delete();
	}

	/**
	 * 删除指定的文件夹
	 *
	 * @param dirPath
	 *            文件夹路径
	 * @param delFile
	 *            文件夹中是否包含文件
	 * @return 若删除成功，则返回True；反之，则返回False
	 *
	 */
	public static boolean delDir(String dirPath, boolean delFile) {
		if (delFile) {
			File file = new File(dirPath);
			if (file.isFile()) {
				return file.delete();
			} else if (file.isDirectory()) {
				if (file.listFiles().length == 0) {
					return file.delete();
				} else {
					int zfiles = file.listFiles().length;
					File[] delfile = file.listFiles();
					for (int i = 0; i < zfiles; i++) {
						if (delfile[i].isDirectory()) {
							delDir(delfile[i].getAbsolutePath(), true);
						}
						delfile[i].delete();
					}
					return file.delete();
				}
			} else {
				return false;
			}
		} else {
			return new File(dirPath).delete();
		}
	}

	/**
	 * 复制文件/文件夹 若要进行文件夹复制，请勿将目标文件夹置于源文件夹中
	 * 
	 * @param source
	 *            源文件（夹）
	 * @param target
	 *            目标文件（夹）
	 * @param isFolder
	 *            若进行文件夹复制，则为True；反之为False
	 * @throws Exception
	 */
	public static void copy(String source, String target, boolean isFolder) throws Exception {
		if (isFolder) {
			(new File(target)).mkdirs();
			File a = new File(source);
			String[] file = a.list();
			File temp = null;
			for (int i = 0; i < file.length; i++) {
				if (source.endsWith(File.separator)) {
					temp = new File(source + file[i]);
				} else {
					temp = new File(source + File.separator + file[i]);
				}
				if (temp.isFile()) {
					FileInputStream input = new FileInputStream(temp);
					FileOutputStream output = new FileOutputStream(target + "/" + (temp.getName()).toString());
					byte[] b = new byte[1024];
					int len;
					while ((len = input.read(b)) != -1) {
						output.write(b, 0, len);
					}
					output.flush();
					output.close();
					input.close();
				}
				if (temp.isDirectory()) {
					copy(source + "/" + file[i], target + "/" + file[i], true);
				}
			}
		} else {
			int byteread = 0;
			File oldfile = new File(source);
			if (oldfile.exists()) {
				InputStream inStream = new FileInputStream(source);
				File file = new File(target);
				file.getParentFile().mkdirs();
				file.createNewFile();
				FileOutputStream fs = new FileOutputStream(file);
				byte[] buffer = new byte[1024];
				while ((byteread = inStream.read(buffer)) != -1) {
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
				fs.close();
			}
		}
	}

	/**
	 * 移动指定的文件（夹）到目标文件（夹）
	 * 
	 * @param source
	 *            源文件（夹）
	 * @param target
	 *            目标文件（夹）
	 * @param isFolder
	 *            若为文件夹，则为True；反之为False
	 * @return
	 * @throws Exception
	 */
	public static boolean move(String source, String target, boolean isFolder) throws Exception {
		copy(source, target, isFolder);
		if (isFolder) {
			return delDir(source, true);
		} else {
			return delFile(source);
		}
	}
}