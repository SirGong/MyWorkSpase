package com.xzy.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyCallable implements Callable {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"执行了！");
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) throws Exception {
        MyCallable myCallable = new MyCallable();
        //FutureTask用来接收线程返回的结果
        FutureTask<String> result = new FutureTask<String>(myCallable);
        FutureTask<String> result1 = new FutureTask<String>(myCallable);
        new Thread(result).start();
        new Thread(result1).start();
        System.out.println(result.get());
        System.out.println(result1.get());
    }
}
