package com.company.manerger.sys.ui.beetl.tag;

import com.company.manerger.sys.common.utils.SpringContextHolder;
import com.company.manerger.sys.common.utils.StringUtils;
import com.company.manerger.sys.common.utils.trace.ErrorInfoBuilder;
import com.company.manerger.sys.ui.beetl.tag.exception.BeetlTagException;
import org.beetl.core.BodyContent;
import org.beetl.core.GeneralVarTagBinding;
import org.beetl.core.Tag;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.Enumeration;
import java.util.Hashtable;
import org.slf4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 没有完整的实现
 *
 */
public class TagSupport extends GeneralVarTagBinding {

    public static final String PARENT_VARIABLE_NAME = "parent_variable_name";
    public static final String STRIKETHROUGH_END_TAG = "Strikethrough";
    public int SKIP_BODY = 0;
    public int EVAL_BODY_INCLUDE = 1;
    public int SKIP_PAGE = 5;
    public int EVAL_PAGE = 6;
//    protected final Log logger = LogFactory.getLog(getClass());
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    private static volatile ConversionService conversionService;
    private Tag parent;
    private Hashtable values;
    protected String id;

    public TagSupport() {
    }

    @Override
    public void render() {
        try {
            // 处理数据
            if (this.args.length >= 2) {
                Map<String, Object> map = (Map)this.args[1];
                Iterator argsIterator = map.entrySet().iterator();
                while(argsIterator.hasNext()) {
                    Map.Entry<String, Object> entry = (Map.Entry)argsIterator.next();
                    String fieldName = (String) entry.getKey();
                    Object fieldValue = entry.getValue();
                    Field field = ReflectionUtils.findField(this.getClass(),fieldName);
                    if (field!=null){
                        setValue(field,fieldValue);
                    }else{
                        if (this instanceof DynamicAttributes) {
                            DynamicAttributes dynamicAttributes = (DynamicAttributes)this;
                            // 处理beetl中划线问题
                            if (StringUtils.endsWith(fieldName,STRIKETHROUGH_END_TAG)) {
                                fieldName = StringUtils.substring(fieldName,0,fieldName.length()-STRIKETHROUGH_END_TAG.length());
                                fieldName = StringUtils.camelToStrikethrough(fieldName);
                            }
                            dynamicAttributes.setDynamicAttribute(fieldName, fieldValue);
                        }
                    }
                }
            }
            //设置父亲以及的标签
            if (this.ctx.globalVar.containsKey(PARENT_VARIABLE_NAME)){
                Tag parent = (Tag)this.ctx.globalVar.get(PARENT_VARIABLE_NAME);
                setParent(parent);
            }
            // 解析标签体
            int evalFlag = doStartTag();
            if (evalFlag == SKIP_PAGE){ // 忽略标签后面的JSP内容。
                return ;
            }
            if (evalFlag == EVAL_BODY_INCLUDE){ // 表示需要处理标签体。
                this.doBodyRender();
            }
            if (evalFlag == BodyTag.EVAL_BODY_BUFFERED){ // 处理标签体。
                BodyTag bodyTag = (BodyTag)this;
                BodyContent bodyContent = this.getBodyContent();
                bodyTag.doInitBody();
                bodyTag.setBodyContent(bodyContent);
            }
            this.doAfterBody();
            doEndTag();
        }
        catch (BeetlTagException ex) {
            ex.printStackTrace();
//            logger.error(ex.getMessage(), ex);
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();
            ErrorInfoBuilder errorInfoBuilder = SpringContextHolder.getBean(ErrorInfoBuilder.class);
            String errorInfo = errorInfoBuilder.getErrorInfo(request,ex).toString();
            logger.error(errorInfo);
            throw ex;
        }
        catch (Exception ex) {
            ex.printStackTrace();
//            logger.error(ex.getMessage(), ex);
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();
            HttpServletResponse httpResponse  = requestAttributes.getResponse();
            ErrorInfoBuilder errorInfoBuilder = SpringContextHolder.getBean(ErrorInfoBuilder.class);
            String errorInfo = errorInfoBuilder.getErrorInfo(request,ex).toString();
            logger.error(errorInfo);
            throw new BeetlTagException(ex.getMessage());
        }finally {
          doFinally();
        }
    }

    protected int doStartTag() throws BeetlTagException {
        return SKIP_BODY;
    }

    protected int doEndTag() throws BeetlTagException {
        return EVAL_PAGE;
    }

    protected int doAfterBody() throws BeetlTagException {
        return SKIP_BODY;
    }

    public void doFinally() {
    }

    public void release() {
        this.parent = null;
        this.id = null;
        if (this.values != null) {
            this.values.clear();
        }

        this.values = null;
    }

    public void setParent(Tag t) {
        this.parent = t;
    }

    public Tag getParent() {
        return this.parent;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setValue(String k, Object o) {
        if (this.values == null) {
            this.values = new Hashtable();
        }

        this.values.put(k, o);
    }

    public Object getValue(String k) {
        return this.values == null ? null : this.values.get(k);
    }

    public void removeValue(String k) {
        if (this.values != null) {
            this.values.remove(k);
        }

    }

    public Enumeration getValues() {
        return this.values == null ? null : this.values.keys();
    }

    private void setValue(Field field,final Object fieldValue) {
        try {
            BeanWrapperImpl beanWrapper = new BeanWrapperImpl(this);
            beanWrapper.setAutoGrowNestedPaths(true);
            beanWrapper.setConversionService(getConversionService());
            beanWrapper.setPropertyValue(field.getName(), fieldValue);
        } catch (Exception e) {

        }
    }

    public static ConversionService getConversionService() {
        if (conversionService == null) {
            synchronized (TagSupport.class) {
                if (conversionService == null) {
                    try {
                        conversionService = new DefaultConversionService();
                    } catch (Exception e) {
                        throw new BeetlTagException(
                                "conversionService is null, " + "query param convert must use conversionService. "
                                        + "please see [com.sishuok.es.common.entity.query.utils."
                                        + "QueryableConvertUtils#setConversionService]");
                    }
                }
            }
        }
        return conversionService;
    }
}

