package com.xzy.threadTest;

/**
 * 程序目的：三个线程交叉打印 ABC
 * 思想：每个线程持有两个锁，上一个线程的锁和自身的锁
 * 为了控制执行的顺序，必须先持有prev锁，前一个线程锁持有的对象锁。再去申请自身的锁。两个锁都持有时方可打印字母
 * 之后先调用self.notifyAll()释放自身锁，唤醒下一个等待线程，再调用prev.wait() 释放prev对象锁，终止当前线程，
 * 等待被再次唤醒。
 */
public class PrintABCThread {
    public static class ThreadPrinter implements Runnable {
        private String name;
        private Object prev;
        private Object self;

        public ThreadPrinter(String name, Object prev, Object self) {
            this.name = name;
            this.prev = prev;
            this.self = self;
        }

        @Override
        public void run() {
            int count = 10;
            while (count > 0) {
                synchronized (prev) {
                    synchronized (self) {
                        System.out.print(name);
                        count--;
                        self.notifyAll();//释放self，等待其他线程竞争self锁
                    }
                    try {
                        //释放prev，使线程进入休眠等待唤醒状态
                        /**
                         * jvm会在wait()对象锁的线程中随机选取一线程，赋予其锁对象，唤醒线程，继续执行。
                         * 这样当count < 0 时就会导致线程无法正常结束。
                         */
                        if(count == 0){
                            prev.notifyAll();
                        }else {
                            prev.wait();

                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        ThreadPrinter pa = new ThreadPrinter("A", c, a);
        ThreadPrinter pb = new ThreadPrinter("B", a, b);
        ThreadPrinter pc = new ThreadPrinter("C", b, c);

        new Thread(pa).start();
        Thread.sleep(10);
        new Thread(pb).start();
        Thread.sleep(10);
        new Thread(pc).start();
        Thread.sleep(10);
    }
}
