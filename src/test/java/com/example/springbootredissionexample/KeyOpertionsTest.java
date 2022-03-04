package com.example.springbootredissionexample;

import com.example.springbootredissionexample.service.KeyOperations;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description:
 * @Version: V1.0
 */
@SpringBootTest
public class KeyOpertionsTest {

    @Autowired
    KeyOperations keyOperations;


    @Test
    void addData() {
        keyOperations.addData();
    }

    @Test
    void foundedKeys() {
        keyOperations.foundedKeys();
    }

    @Test
    void deleteKeys() {
        keyOperations.deleteKeys();
    }
}
