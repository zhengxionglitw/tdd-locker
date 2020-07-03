package com.thoughtworks.locker;

import com.thoughtworks.locker.exception.FullException;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private final Map<Ticket, Bag> storeBags;
    private int availableCapacity;

    public Locker(int capacity) {
        assert (capacity > 0);
        this.storeBags = new HashMap<>(capacity);
        this.availableCapacity = capacity;
    }

    public Ticket store(Bag bag) {
        if (availableCapacity == 0) {
            throw new FullException();
        }
        Ticket ticket = new Ticket();
        storeBags.put(ticket, bag);
        this.availableCapacity--;
        return ticket;
    }
}
