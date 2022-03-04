package com.example.springbootredissionexample;

import com.example.springbootredissionexample.service.BucketOpertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description:
 * @Version: V1.0
 */
@SpringBootTest
class BucketOpertionsTest {

    @Autowired
    BucketOpertions bucketOpertions;

    @Test
    void bucketOper() {
        bucketOpertions.bucketOper();
    }

    @Test
    void bucketsOper() {
        bucketOpertions.bucketsOper();
    }
}
