package com.example.springbootredissionexample;

import com.example.springbootredissionexample.service.RLockOpertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description:
 * @Version: V1.0
 */
@SpringBootTest
class RLockOpertionsTest {

    @Autowired
    RLockOpertions rLockOpertions;

    @Test
    void lock() throws InterruptedException {
        rLockOpertions.lock();
    }

    @Test
    void lockLaseTime() throws InterruptedException {
        rLockOpertions.lockLaseTime();
    }

    @Test
    void tryLock() throws InterruptedException {
        rLockOpertions.tryLock();
    }

    @Test
    void tryLockWaitTime() throws InterruptedException {
        rLockOpertions.tryLockWaitTime();
    }

    @Test
    void tryLockleasTime() throws InterruptedException {
        rLockOpertions.tryLockleasTime();
    }
}
