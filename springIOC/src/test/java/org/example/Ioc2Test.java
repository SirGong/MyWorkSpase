package org.example;

import com.xzy.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ioc2Test {
    @Test
    public void test01(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc2.xml");
        Person person02 = (Person) ioc.getBean("person02");
        System.out.println(person02);
    }
}
