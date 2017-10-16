package com.xzazt.exception;

public class MathException extends RuntimeException {

    public MathException(){
        super();
    }

    public MathException(String message){
        super(message);
    }

    public MathException(String message, Throwable cause){
        super(message,cause);
    }
}
