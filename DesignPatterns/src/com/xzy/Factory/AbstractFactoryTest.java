package com.xzy.Factory;

import org.junit.Test;

public class AbstractFactoryTest {
    @Test
    public void test(){
        AbstractFactory obj = new UpFactory();

        ICar car = obj.create();

        System.out.println(car.getClass());
    }
}
