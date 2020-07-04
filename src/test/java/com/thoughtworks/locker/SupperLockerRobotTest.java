package com.thoughtworks.locker;

import com.thoughtworks.locker.exception.ConfigErrorException;
import com.thoughtworks.locker.robot.SupperLockerRobot;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class SupperLockerRobotTest {
    @Test(expected = AssertionError.class)
    public void should_init_fail_when_init_primary_locker_robot_given_empty_locker_list() {
        new SupperLockerRobot(Collections.emptyList());
    }

    @Test(expected = ConfigErrorException.class)
    public void should_init_fail_when_init_primary_locker_robot_given_locker_list_contains_sLocker() {
        new SupperLockerRobot(Arrays.asList(new SLocker(1)));
    }

}
