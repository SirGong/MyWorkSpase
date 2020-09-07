package com.xzy.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ScoreDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void updateScore(){
        String sql = "UPDATE score SET scoreid=1,scorenum=88 WHERE scoreid=1";
        jdbcTemplate.update(sql);
    }
}






