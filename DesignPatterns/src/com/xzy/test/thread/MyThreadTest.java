package com.xzy.test.thread;

import org.junit.Test;

public class MyThreadTest {
    @Test
    public void test1(){
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.start();
        thread2.start();
    }

}
