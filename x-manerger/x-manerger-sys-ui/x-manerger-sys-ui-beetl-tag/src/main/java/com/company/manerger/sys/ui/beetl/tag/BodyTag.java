package com.company.manerger.sys.ui.beetl.tag;

import org.beetl.core.BodyContent;
import org.beetl.core.GeneralVarTagBinding;
import org.beetl.core.exception.BeetlException;

/**
 * @description: BodyTag
 */
public interface BodyTag {

    int EVAL_BODY_BUFFERED = 2;

    void setBodyContent(BodyContent bodyContent);

    void doInitBody() throws BeetlException;
}