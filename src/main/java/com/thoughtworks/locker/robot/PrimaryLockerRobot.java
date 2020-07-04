package com.thoughtworks.locker.robot;

import com.thoughtworks.locker.AbstractLocker;
import com.thoughtworks.locker.ILocker;
import com.thoughtworks.locker.SizeEnum;
import com.thoughtworks.locker.exception.FullException;

import java.util.List;

public class PrimaryLockerRobot extends AbstractLockerRobot {

    public PrimaryLockerRobot(final List<AbstractLocker> lockerList) {
        super(lockerList);
    }

    @Override
    protected SizeEnum getSize() {
        return SizeEnum.M;
    }

    @Override
    protected ILocker selectLocker() {
        return getLockerList().stream().filter(l -> !l.isFull()).findFirst().orElseThrow(FullException::new);
    }


}
