package com.example.springbootredissionexample;

import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class SpringBootRedissionExampleApplicationTests {

  @Test
  void contextLoads() {}

  @Test
  void testRedissonLock() {
    Config config = new Config();
    config.useSingleServer().setAddress("redis://localhost:6379").setPassword("123456789");
    RedissonClient redisson = Redisson.create(config);
    var rLock = redisson.getLock("order");
    try {
      rLock.lock(30, TimeUnit.SECONDS);
      log.info("我获得了锁");
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      rLock.unlock();
      log.info("我释放了锁");
    }
  }
}
