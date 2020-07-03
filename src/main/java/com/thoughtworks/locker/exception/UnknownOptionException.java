package com.thoughtworks.locker.exception;

public class UnknownOptionException extends RuntimeException {
    public UnknownOptionException() {
        super("不支持操作");
    }
}
