package cn.jeeweb.core.query.exception;

@SuppressWarnings("serial")
public final class InvalidQueryValueException extends QueryException {

	public InvalidQueryValueException(String property, Object value) {
		this(property, value, null);
	}

	public InvalidQueryValueException(String property, Object value, Throwable cause) {
		super("Invalid Query Value, queryProperty [" + property + "], value [" + value + "]", cause);
	}

}
