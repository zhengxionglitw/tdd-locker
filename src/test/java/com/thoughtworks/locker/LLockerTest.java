package com.thoughtworks.locker;

import com.thoughtworks.locker.exception.UnknownOptionException;
import org.junit.Test;

public class LLockerTest {
    @Test(expected = UnknownOptionException.class)
    public void should_store_fail_when_Llocker_store_bag_given_Lokcer() {
        LLocker lLocker = new LLocker(1);

        lLocker.store(new Bag());
    }

    @Test(expected = UnknownOptionException.class)
    public void should_retrieval_fail_when_Llocker_retrieval_bag_given_Lokcer() {
        LLocker lLocker = new LLocker(1);

        lLocker.retrieval(new Ticket());
    }
}
