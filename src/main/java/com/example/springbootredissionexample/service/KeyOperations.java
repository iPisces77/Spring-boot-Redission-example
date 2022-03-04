package com.example.springbootredissionexample.service;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RKeys;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

/**
 * @ClassName KeyOpertions.java @Description 关于key的操作
 */
@Slf4j
@Component
public class KeyOperations {

  final RedissonClient redissonClient;

  public KeyOperations(RedissonClient redissonClient) {
    this.redissonClient = redissonClient;
  }

  public void addData() {
    for (int i = 0; i < 10; i++) {
//      set sucurity:aa+i redisson+i
      RBucket<Object> bucket = redissonClient.getBucket("security:aa" + i);
      bucket.set("redisson" + i);
    }
  }

  public void foundedKeys() {
    // 获得所有keys
    RKeys keys = redissonClient.getKeys();
    Iterable<String> keysAll = keys.getKeys();
    for (String key : keysAll) {
      log.info("获得key:" + key);
    }
    // 获得所有security开头的key
    Iterable<String> redisKeys = keys.getKeysByPattern("security*");
    for (String key : redisKeys) {
      log.info("获得key:" + key);
    }
  }

  public void deleteKeys() {
    // 获得所有keys
    RKeys keys = redissonClient.getKeys();
    long flag = keys.delete("security:aa2", "security:aa4");
    log.info("批量删除key:security:aa2,security:aa4:{}", flag);
    flag = keys.deleteByPattern("security:aa*");
    log.info("模糊删除key:security:aa*:{}", flag);
  }
}
