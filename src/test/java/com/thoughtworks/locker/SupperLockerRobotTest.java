package com.thoughtworks.locker;

import com.thoughtworks.locker.exception.ConfigErrorException;
import com.thoughtworks.locker.robot.PrimaryLockerRobot;
import com.thoughtworks.locker.robot.SupperLockerRobot;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class SupperLockerRobotTest {
    @Test(expected = AssertionError.class)
    public void should_init_fail_when_init_super_locker_robot_given_empty_locker_list() {
        new SupperLockerRobot(Collections.emptyList());
    }

    @Test(expected = ConfigErrorException.class)
    public void should_init_fail_when_init_super_locker_robot_given_locker_list_contains_sLocker() {
        new SupperLockerRobot(Arrays.asList(new SLocker(1)));
    }

    @Test
    public void should_store_success_when_supper_robot_store_given_2_lockers_and_all_have_available_capacity() {
        LLocker locker = new LLocker(2);
        SupperLockerRobot supperLockerRobot = new SupperLockerRobot(Arrays.asList(locker, new LLocker(1)));

        Ticket ticket = supperLockerRobot.store(new Bag());

        Assert.assertNotNull(ticket);
        Assert.assertTrue(locker.exists(ticket));
    }

    @Test
    public void should_store_locker2_when_supper_robot_store_given_2_lockers_and_locker1_available_1_locker2_available_2() {
        LLocker locker = new LLocker(2);
        SupperLockerRobot supperLockerRobot = new SupperLockerRobot(Arrays.asList(new LLocker(1), locker));

        Ticket ticket = supperLockerRobot.store(new Bag());

        Assert.assertNotNull(ticket);
        Assert.assertTrue(locker.exists(ticket));
    }

}
