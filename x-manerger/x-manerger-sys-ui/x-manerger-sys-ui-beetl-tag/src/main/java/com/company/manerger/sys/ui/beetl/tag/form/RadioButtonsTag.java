package com.company.manerger.sys.ui.beetl.tag.form;

import com.company.manerger.sys.ui.beetl.tag.annotation.BeetlTagName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@BeetlTagName("form.radiobuttons")
public class RadioButtonsTag extends AbstractMultiCheckedElementTag {

	@Override
	protected String getInputType() {
		return "radio";
	}

}
