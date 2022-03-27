package com.durellinux.showcase.commons.exceptions;

public abstract class ErrorWithCode extends RuntimeException {
    public ErrorWithCode() {
    }

    public ErrorWithCode(String message) {
        super(message);
    }

    public ErrorWithCode(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorWithCode(Throwable cause) {
        super(cause);
    }

    public ErrorWithCode(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public abstract int getCode();
}
