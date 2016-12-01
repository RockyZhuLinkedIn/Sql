package com.rockyzhu.db;

import com.rockyzhu.datamodel.Spider;

/**
 * Created by hozhu on 11/29/16.
 */
public interface SpiderWriteDao {
  Integer insert(Spider spider);
  Integer update(Spider spider);
  void delete(long spiderId);
}
