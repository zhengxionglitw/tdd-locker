package com.thoughtworks.locker;

import com.thoughtworks.locker.robot.AbstractLockerRobot;

public class LLocker extends AbstractLocker {
    public LLocker(int capacity) {
        super(capacity, SizeEnum.L);
    }

    @Override
    protected String getCalledClassName() {
        return AbstractLockerRobot.class.getName();
    }
}
