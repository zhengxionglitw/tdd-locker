package com.thoughtworks.locker.robot;

import com.thoughtworks.locker.AbstractLocker;
import com.thoughtworks.locker.Bag;
import com.thoughtworks.locker.ILocker;
import com.thoughtworks.locker.SizeEnum;
import com.thoughtworks.locker.Ticket;
import com.thoughtworks.locker.exception.ConfigErrorException;
import com.thoughtworks.locker.exception.FullException;
import com.thoughtworks.locker.utils.CollectionUtil;

import java.util.List;

public class PrimaryLockerRobot {
    private final List<AbstractLocker> lockerList;

    public PrimaryLockerRobot(final List<AbstractLocker> lockerList) {
        assert (!CollectionUtil.isEmpty(lockerList));
        checkLockerSize(lockerList, SizeEnum.M);
        this.lockerList = lockerList;
    }

    private void checkLockerSize(List<AbstractLocker> lockerList, SizeEnum size) {
        for (int i = 0; i < lockerList.size(); i++) {
            if (lockerList.get(i).getSize() != size) {
                throw new ConfigErrorException();
            }
        }
    }

    public Ticket store(Bag bag) {
        ILocker locker = lockerList.stream().filter(l -> !l.isFull()).findFirst().orElseThrow(FullException::new);
        return locker.store(bag);
    }
}
