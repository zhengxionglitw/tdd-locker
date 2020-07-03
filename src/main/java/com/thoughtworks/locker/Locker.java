package com.thoughtworks.locker;

import com.thoughtworks.locker.exception.FullException;
import com.thoughtworks.locker.exception.InvalidTicketException;

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

    public Bag retrieval(Ticket ticket) {
        Bag bag = storeBags.get(ticket);
        if (bag == null) {
            throw new InvalidTicketException();
        }
        this.availableCapacity++;
        return bag;
    }

}
