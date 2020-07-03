package com.thoughtworks.locker;

public class MLocker extends AbstractLocker {

    public MLocker(int capacity) {
        super(capacity, SizeEnum.M);
    }
}
