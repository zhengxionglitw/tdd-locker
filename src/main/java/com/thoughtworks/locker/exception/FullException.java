package com.thoughtworks.locker.exception;

public class FullException extends RuntimeException {

    public FullException() {
        super("储物柜已满");
    }
}
