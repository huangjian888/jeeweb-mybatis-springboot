package com.company.manerger.sys.common.idgenerator.zookeeper.curator.exception;

public class CuratorException extends RuntimeException {
    private static final long serialVersionUID = -1;

    public CuratorException() {
        super();
    }

    public CuratorException(String message) {
        super(message);
    }

    public CuratorException(String message, Throwable cause) {
        super(message, cause);
    }

    public CuratorException(Throwable cause) {
        super(cause);
    }
}