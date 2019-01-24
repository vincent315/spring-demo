package com.xzy.Exception;

public class SysuserExistException extends Exception{
    public SysuserExistException(){

    }
    public SysuserExistException(String message) {
        super(message);
    }

    public SysuserExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public SysuserExistException(Throwable cause) {
        super(cause);
    }
}
