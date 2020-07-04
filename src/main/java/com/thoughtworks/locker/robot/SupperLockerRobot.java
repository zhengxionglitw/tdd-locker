package com.thoughtworks.locker.robot;

import com.thoughtworks.locker.AbstractLocker;
import com.thoughtworks.locker.ILocker;
import com.thoughtworks.locker.SizeEnum;
import com.thoughtworks.locker.exception.FullException;

import java.util.Comparator;
import java.util.List;

public class SupperLockerRobot extends AbstractLockerRobot {

    public SupperLockerRobot(List<AbstractLocker> lockerList) {
        super(lockerList);
    }

    @Override
    protected SizeEnum getSize() {
        return SizeEnum.L;
    }

    @Override
    protected ILocker selectLocker() {
        return getLockerList().stream().filter(l -> !l.isFull())
                .sorted(Comparator.comparing(ILocker::getAvailableCapacity).reversed())
                .findFirst().orElseThrow(FullException::new);
    }


}
