package com.company.manerger.sys.ui.tag.tag;

import com.alibaba.fastjson.JSON;
import org.beetl.core.GeneralVarTagBinding;
import java.util.Map;

public class MyTag extends GeneralVarTagBinding {

    @Override
    public void render() {
        System.out.println("test");
        String tagName = (String) this.args[0];
        Map attrs = (Map) args[1];
        // String model = "model";
        //this.binds(model);
        String model = (String) this.ctx.globalVar.get("model");
        System.out.println(tagName);
        System.out.println(JSON.toJSON(attrs));
        int limit = Integer.parseInt((String) this.getAttributeValue("limit"));
        for (int i = 0; i < limit; i++){
            this.binds(i);
            this.doBodyRender();
        }
    }
}
