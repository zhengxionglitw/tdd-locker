package com.thoughtworks.locker.robot;

import com.thoughtworks.locker.AbstractLocker;
import com.thoughtworks.locker.SizeEnum;

import java.util.List;

public class PrimaryLockerRobot extends AbstractLockerRobot {

    public PrimaryLockerRobot(final List<AbstractLocker> lockerList) {
        super(lockerList);
    }

    @Override
    protected SizeEnum getSize() {
        return SizeEnum.M;
    }


}
