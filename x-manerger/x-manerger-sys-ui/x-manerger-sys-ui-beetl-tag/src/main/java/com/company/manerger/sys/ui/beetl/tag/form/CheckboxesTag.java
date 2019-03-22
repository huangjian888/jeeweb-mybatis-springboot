package com.company.manerger.sys.ui.beetl.tag.form;

import com.company.manerger.sys.ui.beetl.tag.annotation.BeetlTagName;
import com.company.manerger.sys.ui.beetl.tag.exception.BeetlTagException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;

@Component
@Scope("prototype")
@BeetlTagName("form.checkboxes")
public class CheckboxesTag extends AbstractMultiCheckedElementTag {

	@Override
	protected int writeTagContent(TagWriter tagWriter) throws BeetlTagException {
		super.writeTagContent(tagWriter);

		if (!isDisabled()) {
			// Write out the 'field was present' marker.
			tagWriter.startTag("input");
			tagWriter.writeAttribute("type", "hidden");
			String name = WebDataBinder.DEFAULT_FIELD_MARKER_PREFIX + getName();
			tagWriter.writeAttribute("name", name);
			tagWriter.writeAttribute("value", processFieldValue(name, "on", getInputType()));
			tagWriter.endTag();
		}
		return SKIP_BODY;
	}

	@Override
	protected String getInputType() {
		return "checkbox";
	}

}
