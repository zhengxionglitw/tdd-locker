package com.thoughtworks.locker;

public class SLocker extends AbstractLocker {

    public SLocker(int capacity) {
        super(capacity, SizeEnum.S);
    }

    @Override
    protected String getCalledClassName() {
        return null;
    }

    public Ticket store(Bag bag) {
        return this.commonStore(bag);
    }
}
