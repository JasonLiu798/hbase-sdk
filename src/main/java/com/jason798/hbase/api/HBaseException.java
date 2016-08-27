package com.jason798.hbase.api;

/**
 * hbase common exception
 */
public class HBaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public HBaseException(){
    }
    public HBaseException(String message) {
        super(message);
    }

    public HBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public HBaseException(Throwable cause) {
        super(cause);
    }

}
