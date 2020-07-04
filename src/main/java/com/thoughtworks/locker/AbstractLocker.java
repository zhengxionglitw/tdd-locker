package com.thoughtworks.locker;

import com.thoughtworks.locker.exception.FullException;
import com.thoughtworks.locker.exception.InvalidTicketException;
import com.thoughtworks.locker.exception.UnknownOptionException;
import com.thoughtworks.locker.robot.IRobot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractLocker implements ILocker {
    private final Set<IRobot> managedByRobots = new HashSet<>();
    private final Map<Ticket, Bag> storeBags;
    private final SizeEnum size;
    private int availableCapacity;

    public AbstractLocker(int capacity, SizeEnum size) {
        assert (capacity > 0);
        this.storeBags = new HashMap<>(capacity);
        this.availableCapacity = capacity;
        this.size = size;
    }

    protected abstract String getCalledClassName();

    @Override
    public Ticket store(Bag bag) {
        checkPermission(getCalledClassName());
        return this.commonStore(bag);
    }

    @Override
    public Bag retrieval(Ticket ticket) {
        checkPermission(getCalledClassName());
        return this.commonRetrieval(ticket);
    }

    @Override
    public int getAvailableCapacity() {
        return availableCapacity;
    }

    @Override
    public void addManagedByRobot(IRobot robot) {
        managedByRobots.add(robot);
    }

    @Override
    public int managedByRobotsNum() {
        return managedByRobots.size();
    }

    public SizeEnum getSize() {
        return size;
    }

    public boolean exists(Ticket ticket) {
        return storeBags.get(ticket) != null;
    }

    public boolean isFull() {
        return this.availableCapacity == 0;
    }

    protected Ticket commonStore(Bag bag) {
        if (availableCapacity == 0) {
            throw new FullException();
        }
        Ticket ticket = new Ticket(size);
        storeBags.put(ticket, bag);
        this.availableCapacity--;
        return ticket;
    }

    protected Bag commonRetrieval(Ticket ticket) {
        Bag bag = storeBags.get(ticket);
        if (bag == null) {
            throw new InvalidTicketException();
        }
        this.availableCapacity++;
        return bag;
    }

    private void checkPermission(String calledClassName) {
        if (calledClassName == null) {
            return;
        }
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTraceElements.length; i++) {
            if (stackTraceElements[i].getClassName().equalsIgnoreCase(calledClassName)) {
                return;
            }
        }
        throw new UnknownOptionException();
    }
}
