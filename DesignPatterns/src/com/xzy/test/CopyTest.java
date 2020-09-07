package com.xzy.test;

import com.xzy.reflect.Person;
import org.junit.Test;

public class CopyTest {
    @Test
    public void test1() {
        Person p1 = new Person("我是P1", 20);
        Person p2 = p1;

        System.out.println(p2 == p1);
        //哈希值相同
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        //一个被修改，另一个随之被修改
        p1.setName("我被p1修改了");

        System.out.println(p1);
        System.out.println(p2);
    }
}
