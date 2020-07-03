package com.thoughtworks.locker;

import com.thoughtworks.locker.robot.PrimaryLockerRobot;
import org.junit.Test;

import java.util.Collections;

public class PrimaryLockerRobotTest {

    @Test(expected = AssertionError.class)
    public void should_init_fail_when_init_primary_locker_robot_given_empty_locker_list() {
        new PrimaryLockerRobot(Collections.emptyList());
    }
}
