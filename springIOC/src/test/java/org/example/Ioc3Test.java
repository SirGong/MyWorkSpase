package org.example;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class Ioc3Test {
    @Test
    public void test01() throws SQLException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc3.xml");
        DataSource dataSource = ioc.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }
}
