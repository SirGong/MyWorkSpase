package com.xzy.single;

/**
 * 静态内部类,装载外部类的时候并不会装载内部类，调用的时候才会装载
 * 同样只会加载一次，解决线程安全问题
 */
public class SingleTonLazy3 {

    private SingleTonLazy3() {
    }

    private static class SingleTonInstance {
        private static final SingleTonLazy3 INSTANCE = new SingleTonLazy3();
    }

    public static SingleTonLazy3 getInstance() {
        return SingleTonInstance.INSTANCE;
    }
}
