package com.company.manerger.sys.ui.beetl.tag;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.company.manerger.sys.ui.beetl.tag.annotation.BeetlTagName;
import com.company.manerger.sys.ui.beetl.tag.exception.BeetlTagException;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.Scope;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.util.JavaScriptUtils;

@Component
@Scope("prototype")
@BeetlTagName("spring.message")
public class MessageTag extends HtmlEscapingAwareTag implements ArgumentAware {
    public static final String DEFAULT_ARGUMENT_SEPARATOR = ",";
    @Nullable
    private MessageSourceResolvable message;
    @Nullable
    private String code;
    @Nullable
    private Object arguments;
    private String argumentSeparator = ",";
    private List<Object> nestedArguments = Collections.emptyList();
    @Nullable
    private String text;
    @Nullable
    private String var;
    private String scope = "page";
    private boolean javaScriptEscape = false;

    public MessageTag() {
    }

    public void setMessage(MessageSourceResolvable message) {
        this.message = message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setArguments(Object arguments) {
        this.arguments = arguments;
    }

    public void setArgumentSeparator(String argumentSeparator) {
        this.argumentSeparator = argumentSeparator;
    }

    public void addArgument(@Nullable Object argument) throws BeetlTagException {
        this.nestedArguments.add(argument);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public void setJavaScriptEscape(boolean javaScriptEscape) throws BeetlTagException {
        this.javaScriptEscape = javaScriptEscape;
    }

    protected final int doStartTagInternal() throws BeetlTagException {
        this.nestedArguments = new LinkedList();
        return 1;
    }

    public int doEndTag() throws BeetlTagException {
        try {
            String msg = this.resolveMessage();
            msg = this.htmlEscape(msg);
            msg = this.javaScriptEscape ? JavaScriptUtils.javaScriptEscape(msg) : msg;
            if (this.var != null) {
                this.ctx.globalVar.put(this.var, msg);
            } else {
                this.writeMessage(msg);
            }

            return 6;
        } catch (IOException var2) {
            throw new BeetlTagException(var2.getMessage(), var2);
        } catch (NoSuchMessageException var3) {
            throw new BeetlTagException(this.getNoSuchMessageExceptionDescription(var3));
        }
    }

    public void release() {
        super.release();
        this.arguments = null;
    }

    protected String resolveMessage() throws BeetlTagException, NoSuchMessageException {
        MessageSource messageSource = this.getMessageSource();
        if (this.message != null) {
            return messageSource.getMessage(this.message, this.getRequestContext().getLocale());
        } else if (this.code == null && this.text == null) {
            throw new BeetlTagException("No resolvable message");
        } else {
            Object[] argumentsArray = this.resolveArguments(this.arguments);
            if (!this.nestedArguments.isEmpty()) {
                argumentsArray = this.appendArguments(argumentsArray, this.nestedArguments.toArray());
            }

            if (this.text != null) {
                String msg = messageSource.getMessage(this.code, argumentsArray, this.text, this.getRequestContext().getLocale());
                return msg != null ? msg : "";
            } else {
                return messageSource.getMessage(this.code, argumentsArray, this.getRequestContext().getLocale());
            }
        }
    }

    private Object[] appendArguments(@Nullable Object[] sourceArguments, Object[] additionalArguments) {
        if (ObjectUtils.isEmpty(sourceArguments)) {
            return additionalArguments;
        } else {
            Object[] arguments = new Object[sourceArguments.length + additionalArguments.length];
            System.arraycopy(sourceArguments, 0, arguments, 0, sourceArguments.length);
            System.arraycopy(additionalArguments, 0, arguments, sourceArguments.length, additionalArguments.length);
            return arguments;
        }
    }

    @Nullable
    protected Object[] resolveArguments(@Nullable Object arguments) throws BeetlTagException {
        if (arguments instanceof String) {
            String[] stringArray = StringUtils.delimitedListToStringArray((String)arguments, this.argumentSeparator);
            if (stringArray.length == 1) {
                Object argument = stringArray[0];
                return argument != null && argument.getClass().isArray() ? ObjectUtils.toObjectArray(argument) : new Object[]{argument};
            } else {
                return stringArray;
            }
        } else if (arguments instanceof Object[]) {
            return (Object[])((Object[])arguments);
        } else if (arguments instanceof Collection) {
            return ((Collection)arguments).toArray();
        } else {
            return arguments != null ? new Object[]{arguments} : null;
        }
    }

    protected void writeMessage(String msg) throws IOException {
        this.ctx.byteWriter.writeString(String.valueOf(msg));
    }

    protected MessageSource getMessageSource() {
        return this.getRequestContext().getMessageSource();
    }

    protected String getNoSuchMessageExceptionDescription(NoSuchMessageException ex) {
        return ex.getMessage();
    }
}
