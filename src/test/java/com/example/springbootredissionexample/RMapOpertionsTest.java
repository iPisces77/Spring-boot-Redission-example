package com.example.springbootredissionexample;

import com.example.springbootredissionexample.service.RMapOpertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description:
 * @Version: V1.0
 */
@SpringBootTest
class RMapOpertionsTest {

    @Autowired
    RMapOpertions rMapOpertions;

    @Test
    void rMapOper() {
        rMapOpertions.rMapOper();
    }
}
