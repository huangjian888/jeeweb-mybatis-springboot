package com.company.manerger.sys.common.utils;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.Locale;
import java.util.Map;

public class FreeMarkerUtils {

	public static final int TEMPLATE_LOADING_FILE = 1;
	public static final int TEMPLATE_LOADING_CLASS = 2;
	public static final Locale LOCALE = Locale.US;
	public static final String ENCODING = "UTF-8";
	public static Configuration configuration = null;

	public static FreeMarkerUtils initByDefaultTemplate() {
		FreeMarkerUtils freeMarker = new FreeMarkerUtils();
		freeMarker.initConfiguration(TEMPLATE_LOADING_CLASS, "/template");
		return freeMarker;
	}

	public static FreeMarkerUtils initByClassTemplate(String templatePath) {
		FreeMarkerUtils freeMarker = new FreeMarkerUtils();
		freeMarker.initConfiguration(TEMPLATE_LOADING_CLASS, templatePath);
		return freeMarker;
	}

	public static FreeMarkerUtils initByFileTemplate(String templatePath) {
		FreeMarkerUtils freeMarker = new FreeMarkerUtils();
		freeMarker.initConfiguration(TEMPLATE_LOADING_FILE, templatePath);
		return freeMarker;
	}

	public void initConfiguration(String templatePath) {
		initConfiguration(TEMPLATE_LOADING_CLASS, templatePath);
	}

	/**
	 * 初始化Freemarker参数配置
	 * @param type 模板文件夹路径类型，1：文件系统路径；2：项目路径
	 * @param templatePath   模板文件夹路径，当type=1时，文件系统中的绝对路径；当type=2时，项目中相对路径，与src同级开始,以"/开头"
	 */
	public void initConfiguration(int type, String templatePath) {
		configuration = new Configuration();
		TemplateLoader templateLoader = null;
		switch (type) {
		case TEMPLATE_LOADING_FILE:
			try {
				if (!FileUtils.isAbsolutePath(templatePath)) {
					// 获取项目全路径
					// 这个目录以后再来确认
					String filePath = ServletUtils.getRequest().getSession().getServletContext().getRealPath("/");
					templatePath = filePath + templatePath;
				}
				templateLoader = new FileTemplateLoader(new File(templatePath));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			break;
		case TEMPLATE_LOADING_CLASS:
			templateLoader = new ClassTemplateLoader(FreeMarkerUtils.class, templatePath);
			break;
		}
		configuration.setTemplateLoader(templateLoader);
		configuration.setLocale(LOCALE);
		configuration.setEncoding(LOCALE, ENCODING);
	}

	/**
	 * 通过模版字符串的接下模版
	 * 
	 * @param templateString
	 * @param model
	 * @return
	 * @return: String
	 */
	public String renderString(String templateString, Map<String, ?> model) {
		try {
			StringWriter result = new StringWriter();
			Template t = new Template("name", new StringReader(templateString), new Configuration());
			// 编码设置2
			t.setEncoding(ENCODING);
			t.process(model, result);
			return result.toString();
		} catch (Exception e) {
			throw Exceptions.unchecked(e);
		}
	}

	/**
	 * 获取Freemarker模板
	 * 
	 * @param name
	 *            模版文件名
	 * @return
	 */
	public Template getTemplate(String name) {
		Template template = null;
		try {
			template = configuration.getTemplate(name);
			template.setEncoding(ENCODING);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return template;
	}

	/**
	 * 将解析之后的文件内容返回字符串
	 * 
	 * @param name
	 *            模板文件名
	 * @param rootMap
	 * @return
	 * @return: String
	 */
	public String processToString(String name, Object rootMap) {
		StringWriter writer = new StringWriter();
		process(name, rootMap, writer);
		return writer.toString();
	}

	/**
	 * 将解析之后的文件内容保存到文件中
	 * 
	 * @param name
	 *            模板文件名
	 * @param rootMap
	 *            数据Map
	 * @param outFile
	 *            保存文件路径
	 */
	public void processToFile(String name, Map<String, Object> rootMap, String outFile) {
		Writer writer = null;
		try {
			// 通过一个文件输出流，就可以写到相应的文件中
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), ENCODING));
			process(name, rootMap, writer);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 将解析放入字符流输出流对象
	 * 
	 * @param name
	 *            模板文件名
	 * @param rootMap
	 *            数据Map
	 * @param writer
	 *            流对象
	 */
	public void process(String name, Object rootMap, Writer writer) {
		process(getTemplate(name), rootMap, writer);
	}

	/**
	 * 将解析放入字符流输出流对象
	 * 
	 * @param template
	 *            模板
	 * @param rootMap
	 *            数据Map
	 * @param writer
	 *            流对象
	 */
	public void process(Template template, Object rootMap, Writer writer) {
		try {
			template.process(rootMap, writer);
		} catch (TemplateException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将解析之后的文件内容打印在控制台
	 * 
	 * @param name
	 *            模板文件名
	 * @param root
	 *            数据Map
	 */
	public void processConsole(String name, Map<String, Object> root) {
		System.out.println(processToString(name, root));
	}

}