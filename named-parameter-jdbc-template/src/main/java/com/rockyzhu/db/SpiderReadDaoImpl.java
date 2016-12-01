package com.rockyzhu.db;

import com.rockyzhu.datamodel.Spider;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;

/**
 * Created by hozhu on 11/29/16.
 */
public class SpiderReadDaoImpl implements SpiderReadDao {


  private DataSource _dataSource;

  public SpiderReadDaoImpl(DataSource dataSource) {
    _dataSource = dataSource;
  }

  @Override
  public Spider get(long id) {
    String sql = String.format("SELECT * FROM spiders WHERE spider_id = :spiderId");
    SqlParameterSource params = new MapSqlParameterSource().addValue("spiderId", id);
    return (Spider)new NamedParameterJdbcTemplate(_dataSource).queryForObject(sql, params, new SpiderMapper());
  }

}
