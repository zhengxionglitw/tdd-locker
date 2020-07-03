package com.thoughtworks.locker;

import com.thoughtworks.locker.exception.InvalidTicketException;

public class SLocker extends AbstractLocker {

    public SLocker(int capacity) {
        super(capacity, SizeEnum.S);
    }

    public Ticket store(Bag bag) {
        return this.commonStore(bag);
    }

    public Bag retrieval(Ticket ticket) {
        Bag bag = this.commonRetrieval(ticket);
        if (bag == null) {
            throw new InvalidTicketException();
        }
        return bag;
    }

}
