package com.thoughtworks.locker;

import com.thoughtworks.locker.robot.IRobot;

public interface ILocker {
    Ticket store(Bag bag);
    Bag retrieval(Ticket ticket);
    void addManagedByRobot(IRobot robot);
    int getAvailableCapacity();
    int managedByRobotsNum();
}
