package org.example;

import com.xzy.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocTest {

    @Test
    public void test01(){
        //从类路径下读取配置文件
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
        //容器帮我们创建对象
        Person person01 = (Person) ioc.getBean("person01");
        System.out.println(person01);
    }
    @Test
    public void test02(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
        Person person = ioc.getBean("person04",Person.class);
        //按照类型去找对应的bean,如果有多个bean就会报错。
        System.out.println(person);
    }

}
