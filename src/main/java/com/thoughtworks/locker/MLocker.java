package com.thoughtworks.locker;

import com.thoughtworks.locker.robot.AbstractLockerRobot;

public class MLocker extends AbstractLocker {

    public MLocker(int capacity) {
        super(capacity, SizeEnum.M);
    }

    @Override
    protected String getCalledClassName() {
        return AbstractLockerRobot.class.getName();
    }
}
