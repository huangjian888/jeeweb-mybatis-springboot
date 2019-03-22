package com.company.generator.manager.common.definition;

import com.company.generator.manager.common.definition.data.Definition;
import com.company.manerger.sys.common.utils.mapper.JaxbMapper;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: Cache工具类
 */
public class DefinitionBuilder implements ResourceLoaderAware,ApplicationListener<ContextRefreshedEvent> {
    private ResourceLoader resourceLoader;
    private String[] fileNames = new String[0];
    private List<Definition> definitionList=new ArrayList<Definition>();
    private Map<String,Definition> definitionMap=new HashMap<String,Definition>();
    private static DefinitionBuilder definitionBuilder;

    public static DefinitionBuilder getDefinitionBuilder() {
        return definitionBuilder;
    }

    public List<Definition> getDefinitionList() {
        return definitionList;
    }

    public Map<String, Definition> getDefinitionMap() {
        return definitionMap;
    }

    public void setFileNames(String[] fileNames) {
        this.fileNames = fileNames;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader=resourceLoader;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            this.definitionBuilder=this;
            boolean flag = this.resourceLoader instanceof ResourcePatternResolver;
            for (String file : fileNames) {
                if (flag) {
                     Resource[] resources = ((ResourcePatternResolver) this.resourceLoader).getResources(file);
                     buildMap(resources);
                } else {
                    Resource resource = ((ResourcePatternResolver) this.resourceLoader).getResource(file);
                    buildMap(resource);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void buildMap(Resource[] resources) throws IOException {
        if (resources == null) {
            return;
        }
        for (Resource resource : resources) {
            buildMap(resource);
        }
    }

    private void buildMap(Resource resource) {
        try {
            Definition definition = JaxbMapper.fromLocation(resource.getURI().getPath(), Definition.class);
            definitionList.add(definition);
            definitionMap.put(definition.getDbType(),definition);
        } catch (Exception e) {
             e.printStackTrace();
        }
    }

}
