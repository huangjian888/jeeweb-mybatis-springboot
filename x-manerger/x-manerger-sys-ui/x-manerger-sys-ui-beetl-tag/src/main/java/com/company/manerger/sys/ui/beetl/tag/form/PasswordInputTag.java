package com.company.manerger.sys.ui.beetl.tag.form;

import com.company.manerger.sys.ui.beetl.tag.annotation.BeetlTagName;
import com.company.manerger.sys.ui.beetl.tag.exception.BeetlTagException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@BeetlTagName("form.password")
public class PasswordInputTag extends InputTag {

	private boolean showPassword = false;


	/**
	 * Is the password value to be rendered?
	 * @param showPassword {@code true} if the password value is to be rendered
	 */
	public void setShowPassword(boolean showPassword) {
		this.showPassword = showPassword;
	}

	/**
	 * Is the password value to be rendered?
	 * @return {@code true} if the password value to be rendered
	 */
	public boolean isShowPassword() {
		return this.showPassword;
	}


	/**
	 * Flags "type" as an illegal dynamic attribute.
	 */
	@Override
	protected boolean isValidDynamicAttribute(String localName, Object value) {
		return !"type".equals(localName);
	}

	/**
	 * Return '{@code password}' causing the rendered HTML '{@code input}'
	 * element to have a '{@code type}' of '{@code password}'.
	 */
	@Override
	protected String getType() {
		return "password";
	}

	/**
	 * The {@link PasswordInputTag} only writes it's value if the
	 * {@link #setShowPassword(boolean) 'showPassword'} property value is
	 * {@link Boolean#TRUE true}.
	 */
	@Override
	protected void writeValue(TagWriter tagWriter) throws BeetlTagException {
		if (this.showPassword) {
			super.writeValue(tagWriter);
		}
		else {
			tagWriter.writeAttribute("value", processFieldValue(getName(), "", getType()));
		}
	}

}
