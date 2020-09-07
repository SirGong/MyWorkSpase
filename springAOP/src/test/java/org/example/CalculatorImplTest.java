package org.example;

import com.xzy.intr.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalculatorImplTest {

    @Test
    public void test01() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取的时候一定要使用它的接口类型，否则报错
        //没有接口的时候用本类类型，spring可以帮我们创建代理对象
        Calculator calculator = ioc.getBean(Calculator.class);
        System.out.println(calculator.mul(4, 5));

        System.out.println(calculator);
        //类型是代理对象，class com.sun.proxy.$Proxy19，所以不能用本类获取
        System.out.println(calculator.getClass());

    }
}
