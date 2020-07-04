package com.thoughtworks.locker;

import com.thoughtworks.locker.exception.ConfigErrorException;
import com.thoughtworks.locker.exception.FullException;
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

    @Test(expected = FullException.class)
    public void should_store_fail_when_primary_robot_store_given_2_lockers_and_all_is_full() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(new MLocker(1), new MLocker(1)));
        primaryLockerRobot.store(new Bag());
        primaryLockerRobot.store(new Bag());

        primaryLockerRobot.store(new Bag());
    }

    @Test
    public void should_retrieval_success_when_primary_robot_retrieval_given_a_valid_ticket() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(new MLocker(1), new MLocker(1)));
        Bag bag = new Bag();
        Ticket ticket = primaryLockerRobot.store(bag);

        Bag retrievalBag = primaryLockerRobot.retrieval(ticket);

        Assert.assertNotNull(retrievalBag);
        Assert.assertEquals(bag, retrievalBag);
    }
}
