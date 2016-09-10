package com.apischan.stanfytest.exceptions;

public class JobsException extends RuntimeException {

    public JobsException(String message) {
        super(message);
    }

    public JobsException(String message, Throwable cause) {
        super(message, cause);
    }

    public JobsException(Throwable cause) {
        super(cause);
    }
}
