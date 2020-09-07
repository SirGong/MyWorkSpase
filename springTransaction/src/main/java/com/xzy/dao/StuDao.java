package com.xzy.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public class StuDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void updateStu(){
        String sql = "UPDATE stu SET stuname ='hello',stuage=15 WHERE stuid=1";
        jdbcTemplate.update(sql);
    }
}



