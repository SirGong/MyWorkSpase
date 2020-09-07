package com.xzy.single;

/**
 * 懒加载的单例模式,使用了同步方法，性能低下
 */
public class SingleTonLazy1 {
    private static SingleTonLazy1 instance;

    private SingleTonLazy1() {
    }

    //通过同步方法实现线程安全
    public static synchronized SingleTonLazy1 getInstance() {
        if (instance == null) {
            instance = new SingleTonLazy1();
        }
        return instance;
    }

}
