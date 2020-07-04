package com.thoughtworks.locker.robot;

import com.thoughtworks.locker.SLocker;
import com.thoughtworks.locker.exception.ConfigErrorException;

public class LockerRobotManager {
    private final PrimaryLockerRobot primaryLockerRobot;
    private final SupperLockerRobot supperLockerRobot;
    private final SLocker sLocker;

    public LockerRobotManager(final PrimaryLockerRobot primaryLockerRobot,
                              final SupperLockerRobot supperLockerRobot,
                              final SLocker sLocker) {
        if (primaryLockerRobot == null || supperLockerRobot == null || sLocker == null) {
            throw new ConfigErrorException();
        }
        this.primaryLockerRobot = primaryLockerRobot;
        this.supperLockerRobot = supperLockerRobot;
        this.sLocker = sLocker;
    }
}
