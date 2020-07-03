package com.thoughtworks.locker.exception;

public class ConfigErrorException extends RuntimeException {
    public ConfigErrorException() {
        super("配置错误");
    }
}
