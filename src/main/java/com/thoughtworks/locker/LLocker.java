package com.thoughtworks.locker;

public class LLocker extends AbstractLocker {
    public LLocker(int capacity) {
        super(capacity, SizeEnum.L);
    }
}