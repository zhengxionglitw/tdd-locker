package com.thoughtworks.locker;

import com.thoughtworks.locker.robot.PrimaryLockerRobot;

public class MLocker extends AbstractLocker {

    public MLocker(int capacity) {
        super(capacity, SizeEnum.M);
    }

    @Override
    protected String getCalledClassName() {
        return PrimaryLockerRobot.class.getName();
    }
}
