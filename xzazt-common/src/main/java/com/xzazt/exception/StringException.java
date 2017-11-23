package com.xzazt.exception;

public class StringException extends RuntimeException{
    public StringException(String message) {
        super(message);
    }

    public StringException(String message, Throwable cause) {
        super(message, cause);
    }

    public StringException(Throwable cause) {
        super(cause);
    }
}
