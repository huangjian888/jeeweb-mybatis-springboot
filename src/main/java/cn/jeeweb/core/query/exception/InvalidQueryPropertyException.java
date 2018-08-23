package cn.jeeweb.core.query.exception;

@SuppressWarnings("serial")
public final class InvalidQueryPropertyException extends QueryException {

	public InvalidQueryPropertyException(String property) {
		this(property, null);
	}

	public InvalidQueryPropertyException(String property, Throwable cause) {
		super("Invalid Query Property [" + property + "]", cause);
	}

}
