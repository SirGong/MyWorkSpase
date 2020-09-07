package com.xzy.single;

/**
 * 双重检查的懒汉式
 */
public class SingleTonLazy2 {
    //volatile 让修改值立即更新
    private static volatile SingleTonLazy2 singleTon;

    private SingleTonLazy2() {
    }

    public static SingleTonLazy2 getInstance() {
        //第一次检查
        if (singleTon == null) {
            synchronized (SingleTonLazy2.class) {
                //第二次检查
                if (singleTon == null) {
                    singleTon = new SingleTonLazy2();
                }
            }
        }
        return singleTon;
    }
}
