package com.thoughtworks.locker.robot;

import com.thoughtworks.locker.AbstractLocker;
import com.thoughtworks.locker.Bag;
import com.thoughtworks.locker.ILocker;
import com.thoughtworks.locker.SizeEnum;
import com.thoughtworks.locker.Ticket;
import com.thoughtworks.locker.exception.ConfigErrorException;
import com.thoughtworks.locker.exception.InvalidTicketException;
import com.thoughtworks.locker.exception.TypeNotMatchException;
import com.thoughtworks.locker.utils.CollectionUtil;

import java.util.List;

public abstract class AbstractLockerRobot implements IRobot {
    private final List<AbstractLocker> lockerList;

    public AbstractLockerRobot(final List<AbstractLocker> lockerList) {
        assert (!CollectionUtil.isEmpty(lockerList));
        checkLockerSize(lockerList, getSize());
        for (ILocker locker : lockerList) {
            locker.addManagedByRobot(this);
        }
        this.lockerList = lockerList;
    }

    public List<AbstractLocker> getLockerList() {
        return lockerList;
    }

    private void checkLockerSize(List<AbstractLocker> lockerList, SizeEnum size) {
        for (int i = 0; i < lockerList.size(); i++) {
            if (lockerList.get(i).getSize() != size) {
                throw new ConfigErrorException();
            }
        }
    }

    public Ticket store(Bag bag) {
        ILocker locker = selectLocker();
        return locker.store(bag);
    }

    public Bag retrieval(Ticket ticket) {
        if (getSize() != ticket.getSize()) {
            throw new TypeNotMatchException();
        }
        ILocker locker = lockerList.stream().filter(l -> l.exists(ticket)).findFirst().orElseThrow(InvalidTicketException::new);
        return locker.retrieval(ticket);
    }

    protected abstract SizeEnum getSize();

    protected abstract ILocker selectLocker();
}
