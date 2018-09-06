package cn.jeeweb.core.query.exception;

import org.springframework.core.NestedRuntimeException;

public class QueryException extends NestedRuntimeException {

	private static final long serialVersionUID = 1L;

	public QueryException(String msg) {
		super(msg);
	}

	public QueryException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
