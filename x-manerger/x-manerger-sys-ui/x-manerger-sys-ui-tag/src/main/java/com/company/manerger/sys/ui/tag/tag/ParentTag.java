package com.company.manerger.sys.ui.tag.tag;

import org.beetl.core.BodyContent;
import org.beetl.core.GeneralVarTagBinding;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Iterator;
import java.util.Map;

public class ParentTag extends GeneralVarTagBinding {
    @Autowired
    private GroupTemplate groupTagTemplate;
    @Override
    public void render() {
        Template t = groupTagTemplate.getHtmlFunctionOrTagTemplate("/parent.tag", this.ctx.getResourceId());
        t.binding(this.ctx.globalVar);
        t.dynamic(this.ctx.objectKeys);
        if (this.args.length > 2) {
            Map<String, Object> map = (Map)this.args[1];
            Iterator var4 = map.entrySet().iterator();
            while(var4.hasNext()) {
                Map.Entry<String, Object> entry = (Map.Entry)var4.next();
                t.binding((String)entry.getKey(), entry.getValue());
            }
        }
        this.ctx.globalVar.put("model","sdfsdfsdfsdf");
        BodyContent bodyContent = this.getBodyContent();
        String body = bodyContent.getBody();
        t.binding("contentBody",body);
        try {
            t.renderTo(this.ctx.byteWriter);
        }catch (Exception e){
            e.printStackTrace();
        }
        this.ctx.globalVar.remove("model");
    }


}
