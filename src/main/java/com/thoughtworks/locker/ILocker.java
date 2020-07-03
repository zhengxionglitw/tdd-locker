package com.thoughtworks.locker;

public interface ILocker {
    Ticket store(Bag bag);
    Bag retrieval(Ticket ticket);
}
