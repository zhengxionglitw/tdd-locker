package com.thoughtworks.locker;

import com.thoughtworks.locker.exception.FullException;
import com.thoughtworks.locker.exception.UnknownOptionException;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractLocker {
    private final Map<Ticket, Bag> storeBags;
    private final SizeEnum size;
    private int availableCapacity;

    public AbstractLocker(int capacity, SizeEnum size) {
        assert (capacity > 0);
        this.storeBags = new HashMap<>(capacity);
        this.availableCapacity = capacity;
        this.size = size;
    }

    public Ticket store(Bag bag) {
        throw new UnknownOptionException();
    }

    public Bag retrieval(Ticket ticket) {
        throw new UnknownOptionException();
    }

    public SizeEnum getSize() {
        return size;
    }

    protected Ticket commonStore(Bag bag) {
        if (availableCapacity == 0) {
            throw new FullException();
        }
        Ticket ticket = new Ticket();
        storeBags.put(ticket, bag);
        this.availableCapacity--;
        return ticket;
    }

    protected Bag commonRetrieval(Ticket ticket) {
        Bag bag = storeBags.get(ticket);
        if (bag != null) {
            this.availableCapacity++;
        }
        return bag;
    }
}
