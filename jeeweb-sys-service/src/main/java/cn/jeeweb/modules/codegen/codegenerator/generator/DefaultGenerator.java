package cn.jeeweb.modules.codegen.codegenerator.generator;

import cn.jeeweb.core.utils.FreeMarkerUtils;
import cn.jeeweb.core.utils.PropertiesUtil;
import cn.jeeweb.core.utils.StringUtils;
import cn.jeeweb.modules.codegen.codegenerator.data.GeneratorInfo;
import cn.jeeweb.modules.codegen.codegenerator.exception.GenerationException;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * 
 * All rights Reserved, Designed By www.jeeweb.cn
 * 
 * @title: DefaultGenerator.java
 * @package cn.jeeweb.modules.codegen.codegenerator.generator
 * @description: 默认代码生成器
 * @author: auth_team
 * @date: 2017年4月24日 下午1:05:58
 * @version V1.0
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *
 */
public class DefaultGenerator implements IGenerator {
	public final static int CODE_TYPE_JAVA = 1;
	public final static int CODE_TYPE_JSP = 2;
	public final static int CODE_TYPE_MAPPER = 3;
	public static final String DEFAULT_CONFIG_FILE = "codegen.properties";
	private String configname = DEFAULT_CONFIG_FILE;
	private PropertiesUtil generatorProperties = new PropertiesUtil(configname);

	private GeneratorConfig config;

	public DefaultGenerator() {
	}

	public DefaultGenerator(GeneratorConfig config) {
		this.config = config;

	}

	protected String getRootPackage() {
		String rootPackage = "";
		if (config.getCodeType() == CODE_TYPE_JSP) {
			rootPackage = generatorProperties.getString("webroot.package", "/src/main/webapp/");
		} else if (config.getCodeType() == CODE_TYPE_MAPPER) {
			rootPackage = generatorProperties.getString("resources.root.package", "/src.main.resources/");
		} else {
			rootPackage = generatorProperties.getString("source.root.package", "/src/main/java/");
		}
		return rootPackage;
	}

	protected String getOutPath(GeneratorInfo generatorInfo) {
		String outPath = getRootPackage();
		// 默认生成的包名
		String packageName = generatorInfo.getPackageName();
		if (config.getCodeType() == CODE_TYPE_JSP) {
			outPath = outPath += File.separator + "WEB-INF/webpage/modules";
		} else if (config.getCodeType() == CODE_TYPE_MAPPER) {
			outPath = outPath += File.separator + "/mappings/modules/";
		} else {
			if (!"".endsWith(packageName)) {
				outPath += File.separator + packageName;
			}
		}
		// 当前模块名
		String moduleName = generatorInfo.getModuleName();
		if (!"".endsWith(moduleName)) {
			outPath += File.separator + moduleName;
		}
		// 层级目录
		String layerPackage = config.getLayer();
		if (!"".endsWith(layerPackage)) {
			if (config.getCodeType() == CODE_TYPE_JSP) {
				layerPackage = layerPackage.replace("[entityName]", generatorInfo.getEntityName()).toLowerCase();
				outPath += File.separator + layerPackage;
			}else if (config.getCodeType() == CODE_TYPE_MAPPER) {
				 
			} else {
				outPath += File.separator + layerPackage;
			}
		}
		//
		outPath = outPath.replace(".", File.separator).trim();
		return outPath;
	}

	public void setConfig(GeneratorConfig config) {
		this.config = config;
	}

	@Override
	public void generate(GeneratorInfo generatorInfo, Map<String, Object> dataMap)
			throws IOException, GenerationException {
		String ftl = "/template/code/" + config.getTemplateFile();
		if (generatorInfo.getType() != null && generatorInfo.getType().equals("4")) {
			ftl = "/template/code/tree/" + config.getTemplateFile();
		} else if (generatorInfo.getType() != null && generatorInfo.getType().equals("2")) {
			ftl = "/template/code/onetomany/" + config.getTemplateFile();
		}
		String outPath = generatorInfo.getPathName() + "/" + getOutPath(generatorInfo) + "/";
		File outPathFile = new File(outPath);
		if (!outPathFile.exists()) {
			outPathFile.mkdirs();
		}
		String fileName = config.getNameFormat().replace("[entityName]", generatorInfo.getEntityName());
		if (config.getCodeType() == CODE_TYPE_JSP) {
			fileName = StringUtils.camelToUnderline(fileName);
		}
		File outFile = new File(outPath + fileName);
		if (outFile.exists()) {
			outFile.delete();
		}
		FreeMarkerUtils.initByClassTemplate("/codegen").processToFile(ftl, dataMap, outFile.getAbsolutePath());
	}

	public static class GeneratorConfig {
		private String key = "";// 注册关键字
		private String layer = "";// 文件层
		private String templateFile = ""; // 模版名称
		private int codeType = 1; // 是否JSP,1.JAVA,2.页面代码
		private String nameFormat = ""; // 命名格式

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getLayer() {
			return layer;
		}

		public void setLayer(String layer) {
			this.layer = layer;
		}

		public String getTemplateFile() {
			return templateFile;
		}

		public void setTemplateFile(String templateFile) {
			this.templateFile = templateFile;
		}

		public String getNameFormat() {
			return nameFormat;
		}

		public void setNameFormat(String nameFormat) {
			this.nameFormat = nameFormat;
		}

		public int getCodeType() {
			return codeType;
		}

		public void setCodeType(int codeType) {
			this.codeType = codeType;
		}

	}
}
