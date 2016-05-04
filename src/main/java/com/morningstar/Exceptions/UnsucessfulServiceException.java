package com.morningstar.Exceptions;

/**
 * Created by Sanit Thale on 3/28/2016 11:30 AM.
 */
public class UnsucessfulServiceException extends RuntimeException {

    public UnsucessfulServiceException() {
        super("Not able to perform the operation");
    }

    public UnsucessfulServiceException(String message) {
        super(message);
    }

    public UnsucessfulServiceException(String message, Throwable cause) {
        super(message, cause);
    }

       public void PageNotLoadedError(){
    }
}
