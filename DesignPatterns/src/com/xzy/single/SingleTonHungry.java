package com.xzy.single;

/**
 * 勤汉模式-静态常量
 */
public class SingleTonHungry {
    //私有化构造器
    private SingleTonHungry() {
    }

    //静态实例对象
    private static final SingleTonHungry instance = new SingleTonHungry();
    //在静态代码块中实例化对象
    /*    static {
        instance = new SingleTonHungry1();
    }
    */


    //提供公开的方法返回实例对象
    public SingleTonHungry getInstance() {
        return instance;
    }
}
