package com.thoughtworks.locker;

import com.thoughtworks.locker.exception.ConfigErrorException;
import com.thoughtworks.locker.robot.LockerRobotManager;
import org.junit.Test;

public class LockerRobotManagerTest {

    @Test(expected = ConfigErrorException.class)
    public void should_init_fail_when_init_robot_manager_given_primary_robot_null_supper_robot_null_slocker_null() {
        new LockerRobotManager(null, null, null);
    }
}
