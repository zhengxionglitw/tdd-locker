package com.thoughtworks.locker.exception;

public class InvalidTicketException extends RuntimeException {

    public InvalidTicketException() {
        super("无效票据");
    }
}
