package com.thoughtworks.locker;

import org.junit.Test;

public class LockerTest {

    @Test(expected = AssertionError.class)
    public void should_throw_assert_exception_when_init_locker_given_capacity_is_0() {
        new Locker(0);
    }

    @Test(expected = AssertionError.class)
    public void should_throw_assert_exception_when_init_locker_given_capacity_lt_0() {
        new Locker(0);
    }

    @Test
    public void should_success_when_init_locker_given_capacity_gt_0() {
        new Locker(1);
    }
}
