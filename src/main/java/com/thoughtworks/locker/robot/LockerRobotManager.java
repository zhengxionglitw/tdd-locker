package com.thoughtworks.locker.robot;

import com.thoughtworks.locker.Bag;
import com.thoughtworks.locker.SLocker;
import com.thoughtworks.locker.SizeEnum;
import com.thoughtworks.locker.Ticket;
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

    public Ticket store(Bag bag) {
        Ticket ticket;
        if (bag.getSize() == SizeEnum.S) {
            ticket = sLocker.store(bag);
        } else if (bag.getSize() == SizeEnum.M) {
            ticket = primaryLockerRobot.store(bag);
        } else {
            ticket = supperLockerRobot.store(bag);
        }

        return ticket;
    }

    public Bag retrieval(Ticket ticket) {
        Bag bag;
        if (ticket.getSize() == SizeEnum.S) {
            bag = sLocker.retrieval(ticket);
        } else if (ticket.getSize() == SizeEnum.M) {
            bag = primaryLockerRobot.retrieval(ticket);
        } else {
            bag = supperLockerRobot.retrieval(ticket);
        }
        return bag;
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
