package com.company.manerger.sys.ui.tag.form;

import com.company.manerger.sys.common.utils.SpringContextHolder;
import com.company.manerger.sys.common.utils.StringUtils;
import com.company.manerger.sys.ui.beetl.tag.annotation.BeetlTagName;
import com.company.manerger.sys.ui.beetl.tag.exception.BeetlTagException;
import com.company.manerger.sys.ui.beetl.tag.form.HiddenInputTag;
import com.company.manerger.sys.ui.beetl.tag.form.TagWriter;
import com.company.manerger.sys.ui.tag.form.support.FreemarkerFormTagHelper;
import com.company.manerger.sys.ui.tag.html.manager.HtmlComponentManager;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Scope("prototype")
@BeetlTagName("form.gallery")
public class GalleryTag extends HiddenInputTag {
    protected String imgWidth = "100%";
    protected String imgHeight = "100%";

    public String getImgWidth() {
        return imgWidth;
    }

    public void setImgWidth(String imgWidth) {
        this.imgWidth = imgWidth;
    }

    public String getImgHeight() {
        return imgHeight;
    }

    public void setImgHeight(String imgHeight) {
        this.imgHeight = imgHeight;
    }

    @Override
    protected int writeTagContent(TagWriter tagWriter) throws BeetlTagException {
        tagWriter.startTag("input");
        writeDefaultAttributes(tagWriter);
        tagWriter.writeAttribute("type", "hidden");
        if (isDisabled()) {
            tagWriter.writeAttribute(DISABLED_ATTRIBUTE, "disabled");
        }
        String value = getDisplayString(getBoundValue(), getPropertyEditor());
        tagWriter.writeAttribute("value", processFieldValue(getName(), value, "hidden"));
        tagWriter.endTag();
        // 输出编辑器代码片段
        writeFragment(tagWriter);
        return SKIP_BODY;
    }

    private void writeFragment(TagWriter tagWriter) throws BeetlTagException {
        Map<String, Object> rootMap = FreemarkerFormTagHelper.getTagStatic(this, this.ctx);
        String value = getDisplayString(getBoundValue(), getPropertyEditor());
        rootMap.put("value", processFieldValue(getName(), value, "hidden"));
        rootMap.put("path", resolveId());
        rootMap.put("imgWidth", imgWidth);
        rootMap.put("imgHeight", imgHeight);
        HtmlComponentManager htmlComponentManager = SpringContextHolder.getApplicationContext().getBean(HtmlComponentManager.class);
        String fragment = htmlComponentManager.getFragmentComponent("gallery-file", rootMap);
        if (!StringUtils.isEmpty(fragment) && !fragment.equals("null")) {
            // 获得编辑器
            tagWriter.forceAppendValue(fragment);
        }
    }
}
