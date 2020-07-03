package com.thoughtworks.locker;

import com.thoughtworks.locker.exception.UnknownOptionException;
import org.junit.Test;

public class MLockerTest {
    @Test(expected = UnknownOptionException.class)
    public void should_store_fail_when_Mlocker_store_bag_given_MLokcer() {
        MLocker mLocker = new MLocker(1);

        mLocker.store(new Bag());
    }

    @Test(expected = UnknownOptionException.class)
    public void should_retrieval_fail_when_Mlocker_retrieval_bag_given_MLokcer() {
        MLocker mLocker = new MLocker(1);

        mLocker.retrieval(new Ticket());
    }
}
