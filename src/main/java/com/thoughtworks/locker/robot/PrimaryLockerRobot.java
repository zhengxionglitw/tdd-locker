package com.thoughtworks.locker.robot;

import com.thoughtworks.locker.AbstractLocker;
import com.thoughtworks.locker.utils.CollectionUtil;

import java.util.List;

public class PrimaryLockerRobot {
    private final List<AbstractLocker> lockerList;

    public PrimaryLockerRobot(final List<AbstractLocker> lockerList) {
        assert (!CollectionUtil.isEmpty(lockerList));
        this.lockerList = lockerList;
    }
}
