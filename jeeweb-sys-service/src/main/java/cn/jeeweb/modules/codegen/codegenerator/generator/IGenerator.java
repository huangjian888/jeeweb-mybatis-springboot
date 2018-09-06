package cn.jeeweb.modules.codegen.codegenerator.generator;

import cn.jeeweb.modules.codegen.codegenerator.data.GeneratorInfo;
import cn.jeeweb.modules.codegen.codegenerator.exception.GenerationException;

import java.io.IOException;
import java.util.Map;

public interface IGenerator {
	void generate(GeneratorInfo generatorInfo, Map<String, Object> dataMap) throws IOException,
            GenerationException;
}
