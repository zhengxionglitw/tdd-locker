package com.thoughtworks.locker.exception;

public class TypeNotMatchException extends RuntimeException {
    public TypeNotMatchException() {
        super("票据型号不对");
    }
}
