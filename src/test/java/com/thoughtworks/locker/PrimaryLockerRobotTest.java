package com.thoughtworks.locker;

import com.thoughtworks.locker.exception.ConfigErrorException;
import com.thoughtworks.locker.robot.PrimaryLockerRobot;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class PrimaryLockerRobotTest {

    @Test(expected = AssertionError.class)
    public void should_init_fail_when_init_primary_locker_robot_given_empty_locker_list() {
        new PrimaryLockerRobot(Collections.emptyList());
    }

    @Test(expected = ConfigErrorException.class)
    public void should_init_fail_when_init_primary_locker_robot_given_locker_list_contains_sLocker() {
        new PrimaryLockerRobot(Arrays.asList(new SLocker(1)));
    }

    @Test
    public void should_store_success_when_primary_robot_store_given_2_lockers_and_all_have_available_capacity() {
        MLocker locker = new MLocker(1);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(locker, new MLocker(1)));

        Ticket ticket = primaryLockerRobot.store(new Bag());

        Assert.assertNotNull(ticket);
        Assert.assertTrue(locker.exists(ticket));
    }

    @Test
    public void should_store_success_when_primary_robot_store_given_2_lockers_and_locker1_is_full() {
        MLocker locker = new MLocker(1);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(new MLocker(1), locker));
        primaryLockerRobot.store(new Bag());

        Ticket ticket = primaryLockerRobot.store(new Bag());

        Assert.assertNotNull(ticket);
        Assert.assertTrue(locker.exists(ticket));
    }
}
