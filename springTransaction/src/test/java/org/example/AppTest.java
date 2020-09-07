package org.example;

import com.xzy.service.Transactions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AppTest {
    @Autowired
    DataSource dataSource;
    @Autowired
    Transactions service;
    @Test
    public void test1() throws SQLException {

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
    @Test
    public void test2(){
        service.updateTwoTable();
    }
    @Test
    public void test3(){
        System.out.println(service);
    }



}
