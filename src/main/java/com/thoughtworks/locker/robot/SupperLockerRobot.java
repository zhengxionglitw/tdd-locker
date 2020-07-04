package com.thoughtworks.locker.robot;

import com.thoughtworks.locker.AbstractLocker;
import com.thoughtworks.locker.SizeEnum;

import java.util.List;

public class SupperLockerRobot extends AbstractLockerRobot {

    public SupperLockerRobot(List<AbstractLocker> lockerList) {
        super(lockerList);
    }

    @Override
    protected SizeEnum getSize() {
        return SizeEnum.L;
    }


}
