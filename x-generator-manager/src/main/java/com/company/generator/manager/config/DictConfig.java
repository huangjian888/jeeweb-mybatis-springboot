package com.company.generator.manager.config;

import com.company.manerger.sys.ui.beetl.tag.dict.Dict;
import com.company.manerger.sys.ui.beetl.tag.dict.DictUtils;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 字典初始化
 */

@Configuration
public class DictConfig implements ApplicationRunner{

    @Override
    public void run(ApplicationArguments var1) throws Exception {
        //初始化页面数据字典
        List<Dict> sfList = new ArrayList<>();
        sfList.add(new Dict("是", "1"));
        sfList.add(new Dict("否", "0"));
        DictUtils.putDict("sf", sfList);
    }
}
