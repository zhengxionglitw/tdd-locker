package com.thoughtworks.locker;

import com.thoughtworks.locker.exception.ConfigErrorException;
import com.thoughtworks.locker.robot.LockerRobotManager;
import com.thoughtworks.locker.robot.PrimaryLockerRobot;
import com.thoughtworks.locker.robot.SupperLockerRobot;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class LockerRobotManagerTest {

    @Test(expected = ConfigErrorException.class)
    public void should_init_fail_when_init_robot_manager_given_primary_robot_null_supper_robot_null_slocker_null() {
        new LockerRobotManager(null, null, null);
    }

    @Test(expected = ConfigErrorException.class)
    public void should_init_fail_when_robot_manager_init_given_locker_is_managed_by_other_robot() {
        MLocker mLocker = new MLocker(1);
        new PrimaryLockerRobot(Arrays.asList(mLocker));

        new LockerRobotManager(new PrimaryLockerRobot(Arrays.asList(mLocker)),
                new SupperLockerRobot(Arrays.asList(new LLocker(1))), new SLocker(1));
    }

    @Test(expected = ConfigErrorException.class)
    public void should_init_fail_when_robot_manager_init_given_supper_robot_locker_is_managed_by_other_robot() {
        LLocker lLocker = new LLocker(1);
        new SupperLockerRobot(Arrays.asList(lLocker));

        new LockerRobotManager(new PrimaryLockerRobot(Arrays.asList(new MLocker(1))),
                new SupperLockerRobot(Arrays.asList(lLocker)), new SLocker(1));
    }

    @Test
    public void should_store_sLocker_when_robot_manager_store_given_a_s_bag_and_sLocker_is_not_full() {
        SLocker locker = new SLocker(1);
        LockerRobotManager manager = new LockerRobotManager(new PrimaryLockerRobot(Arrays.asList(new MLocker(1))),
                new SupperLockerRobot(Arrays.asList(new LLocker(1))), locker);
        Bag sBag = new Bag(SizeEnum.S);

        Ticket ticket = manager.store(sBag);

        Assert.assertNotNull(ticket);
        Assert.assertEquals(sBag, locker.retrieval(ticket));
    }
}
