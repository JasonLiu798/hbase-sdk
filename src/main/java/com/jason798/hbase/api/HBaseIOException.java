package com.jason798.hbase.api;

/**
 * hbase io exception
 */
public class HBaseIOException extends HBaseException {
    private static final long serialVersionUID = 1L;

    public HBaseIOException(){
    }
    public HBaseIOException(String message) {
        super(message);
    }

    public HBaseIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public HBaseIOException(Throwable cause) {
        super(cause);
    }

}
