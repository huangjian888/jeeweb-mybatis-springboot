package cn.jeeweb.modules.codegen.codegenerator;

import cn.jeeweb.core.mapper.JaxbMapper;
import cn.jeeweb.core.utils.MapBeanUtil;
import cn.jeeweb.core.utils.StringUtils;
import cn.jeeweb.modules.codegen.codegenerator.data.AttributeInfo;
import cn.jeeweb.modules.codegen.codegenerator.data.GeneratorInfo;
import cn.jeeweb.modules.codegen.codegenerator.exception.GenerationException;
import cn.jeeweb.modules.codegen.codegenerator.generator.DefaultGenerator;
import cn.jeeweb.modules.codegen.codegenerator.generator.DefaultGenerator.GeneratorConfig;
import cn.jeeweb.modules.codegen.codegenerator.generator.IGenerator;
import cn.jeeweb.modules.codegen.codegenerator.xml.generator.ConfigXmlMap;
import cn.jeeweb.modules.codegen.codegenerator.xml.generator.GeneratorXmlMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneratorManagor {
	private Map<String, IGenerator> generatorMap = new HashMap<String, IGenerator>();
	private final String GENERATOR_DEFAULT_LOCATION = "codegen/mapper/code_generator.xml";
	private String location = GENERATOR_DEFAULT_LOCATION;
	private static GeneratorManagor managor = new GeneratorManagor();
	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	public static GeneratorManagor getManagor() {
		if (managor == null) {
			managor = new GeneratorManagor();
		}
		return managor;
	}

	public GeneratorManagor() {
		try {
			initGeneratorByXml(location);
		} catch (Exception e) {
			logger.error("代码生成器配置“"+GENERATOR_DEFAULT_LOCATION+"”加载失败...");
		}
	}

	public void initGeneratorByXml(String location) {
		// 加载配置
		ConfigXmlMap xmlMap = JaxbMapper.fromLocation(location, ConfigXmlMap.class);
		List<GeneratorXmlMap> GeneratorXmpMapList = xmlMap.getGeneratorXmpMapList();
		for (GeneratorXmlMap generatorXmpMap : GeneratorXmpMapList) {
			GeneratorConfig generatorConfig = new GeneratorConfig();
			generatorConfig.setKey(generatorXmpMap.getKey());
			generatorConfig.setCodeType(generatorXmpMap.getCodeType());
			generatorConfig.setLayer(generatorXmpMap.getLayer());
			generatorConfig.setNameFormat(generatorXmpMap.getNameFormat());
			generatorConfig.setTemplateFile(generatorXmpMap.getTemplateFile());
			registerGenerator(generatorConfig);
		}
	}

	/**
	 * 注册一个代码生成器
	 * 
	 * @param generator
	 */
	public void registerGenerator(GeneratorConfig generatorConfig) {
		IGenerator codeGenerator = new DefaultGenerator(generatorConfig);
		registerGenerator(generatorConfig.getKey(), codeGenerator);
	}

	/**
	 * 注册一个代码生成器
	 * 
	 * @param generator
	 */
	public void registerGenerator(String key, IGenerator generator) {
		generatorMap.put(key, generator);
	}

	public void process(GeneratorInfo generatorInfo) throws IOException, GenerationException {
		Map<String, Object> dataMap = getFtlMap(generatorInfo);
		List<String> generatorKeys = generatorInfo.getGeneratorKeys();
		for (String generatorKey : generatorKeys) {
			if (generatorMap.containsKey(generatorKey)) {
				IGenerator codeGenerator = generatorMap.get(generatorKey);
				codeGenerator.generate(generatorInfo,dataMap);
			}
		}
	}

	public Map<String, Object> getFtlMap(GeneratorInfo generatorInfo) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		try {
			List<String> importTypes = new ArrayList<String>();
			List<AttributeInfo> attributeInfos = generatorInfo.getAttributeInfos();
			Map<String, Boolean> tempImportMap = new HashMap<String, Boolean>();
			if (attributeInfos!=null) {
				for (AttributeInfo attributeInfo : attributeInfos) {
					String importType = attributeInfo.getImportType();
					if (!StringUtils.isEmpty(importType)&&!tempImportMap.containsKey(importType)) {
						importTypes.add(importType);
						tempImportMap.put(importType, true);
					}
				}
				generatorInfo.setImportTypes(importTypes);
			}
			dataMap = MapBeanUtil.convertBean(generatorInfo);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {

			e.printStackTrace();
		}
		return dataMap;
	}
	
	public static void main(String[] args) {
		GeneratorManagor.getManagor();
	}
}
