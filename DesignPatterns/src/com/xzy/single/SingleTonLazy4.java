package com.xzy.single;

import org.junit.Test;

/**
 * 使用枚举内部类可以解决多线程问题，而且可以防止反序列化
 */
public class SingleTonLazy4 {
    //测试
    @Test
    public void test() {
        SingleTon singleTon = SingleTon.INSTANCE;
        SingleTon singleTon1 = SingleTon.INSTANCE;
        singleTon.method();

        System.out.println(singleTon == singleTon1);

    }

    enum SingleTon {
        INSTANCE;

        public void method() {
            System.out.println("枚举的方法");
            //方法
        }
    }
}
