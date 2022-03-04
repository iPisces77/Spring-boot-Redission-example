package com.example.springbootredissionexample.controller;

import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RedissonController {
  private final RedissonClient redissonClient;

  public RedissonController(RedissonClient redissonClient) {
    this.redissonClient = redissonClient;
  }

  @RequestMapping("/redissonLock")
  public String redissonLock() {
    log.info("进入了方法");

    // 1. Create config object
//    Config config = new Config();
//    config.useSingleServer().setAddress("redis://localhost:6379").setPassword("123456789");
//    RedissonClient redisson = Redisson.create(config);
    var rLock = redissonClient.getLock("order");
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
    log.info("方法执行完成");
    return "success";
  }
}
