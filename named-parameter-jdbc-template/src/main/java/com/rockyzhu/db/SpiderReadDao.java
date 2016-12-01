package com.rockyzhu.db;

import com.rockyzhu.datamodel.Spider;

/**
 * Created by hozhu on 11/29/16.
 */
public interface SpiderReadDao {
  Spider get(long id);
}
