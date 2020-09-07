package com.xzy.test1;

import com.xzy.impl.CalculatorImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class calTest {
    @org.junit.Test
    public void test01(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        CalculatorImpl iocBean = ioc.getBean(CalculatorImpl.class);
        iocBean.add(5, 9);

    }

}
