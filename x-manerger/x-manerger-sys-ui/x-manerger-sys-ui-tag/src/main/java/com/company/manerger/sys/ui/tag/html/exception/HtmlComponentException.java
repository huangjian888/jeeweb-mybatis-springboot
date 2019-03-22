package com.company.manerger.sys.ui.tag.html.exception;

@SuppressWarnings("serial")
public class HtmlComponentException extends RuntimeException {

	public HtmlComponentException() {
		super();
	}

	public HtmlComponentException(String msg) {
		super(msg);
	}

	public HtmlComponentException(Exception exception) {
		 super(exception);
	}
}
