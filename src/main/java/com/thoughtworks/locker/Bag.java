package com.thoughtworks.locker;

public class Bag {
    private final SizeEnum size;

    public Bag() {
        this(null);
    }

    public Bag(SizeEnum size) {
        this.size = size;
    }

    public SizeEnum getSize() {
        return size;
    }
}
