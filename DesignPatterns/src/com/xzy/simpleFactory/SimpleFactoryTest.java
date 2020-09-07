package com.xzy.simpleFactory;


import org.junit.Test;

public class SimpleFactoryTest {
    @Test
    public void test(){
        //传入需要创建的对象类型
        ICar car = CarSimpleFactory.create(CarSimpleFactory.MIDTYPE);
        System.out.println(car.getClass());

    }
}
