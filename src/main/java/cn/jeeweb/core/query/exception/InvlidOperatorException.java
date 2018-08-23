package cn.jeeweb.core.query.exception;

import cn.jeeweb.core.query.data.Condition.Operator;

/**
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public final class InvlidOperatorException extends QueryException {

	public InvlidOperatorException(String property, String operatorStr) {
		this(property, operatorStr, null);
	}

	public InvlidOperatorException(String property, String operatorStr, Throwable cause) {
		super("Invalid   Operator property [" + property + "], " + "operator [" + operatorStr + "], must be one of "
				+ Operator.toStringAllOperator(), cause);
	}
}
