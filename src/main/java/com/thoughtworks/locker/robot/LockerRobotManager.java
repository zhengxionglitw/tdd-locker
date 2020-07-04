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
        checkLockers(primaryLockerRobot, supperLockerRobot, sLocker);
        this.primaryLockerRobot = primaryLockerRobot;
        this.supperLockerRobot = supperLockerRobot;
        this.sLocker = sLocker;
    }

    private void checkLockers(final PrimaryLockerRobot primaryLockerRobot,
                              final SupperLockerRobot supperLockerRobot,
                              final SLocker sLocker) {
        if (sLocker.managedByRobotsNum() > 0 ||
                primaryLockerRobot.getLockerList().stream().anyMatch(l -> l.managedByRobotsNum() > 1) ||
                supperLockerRobot.getLockerList().stream().anyMatch(l -> l.managedByRobotsNum() > 1)) {
            throw new ConfigErrorException();
        }
    }
}
