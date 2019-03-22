package com.company.manerger.sys.common.idgenerator.exception;

public class IdGeneratorException  extends RuntimeException{
    private static final long serialVersionUID = -1;

    public IdGeneratorException() {
        super();
    }

    public IdGeneratorException(String message) {
        super(message);
    }

    public IdGeneratorException(String message, Throwable cause) {
        super(message, cause);
    }

    public IdGeneratorException(Throwable cause) {
        super(cause);
    }
}
