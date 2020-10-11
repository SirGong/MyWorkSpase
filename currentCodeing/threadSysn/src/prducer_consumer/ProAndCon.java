package prducer_consumer;

import java.util.LinkedList;

public class ProAndCon {
    private static int MAXSIZE = 5;
    private static LinkedList<Integer> list = new LinkedList<>();

    class Producer implements Runnable{
        @Override
        public void run() {
            synchronized(list){
                //缓存无剩余空间
                while (list.size() == MAXSIZE){
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.add(1);
                System.out.println(Thread.currentThread().getName()+"生产者生产产品,仓库容量为："+list.size());
                list.notify();
            }
        }
    }
    class Consumer implements Runnable{
        @Override
        public void run() {
            synchronized (list){
                while (list.isEmpty()){
                    System.out.println("仓库为空！");
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.removeFirst();
                System.out.println(Thread.currentThread().getName()+"消费者消费产品，剩余容量为："+list.size());
                list.notify();
            }
        }
    }

    public static void main(String[] args) {
        ProAndCon proAndCon = new ProAndCon();
        Producer producer = proAndCon.new Producer();
        Consumer consumer = proAndCon.new Consumer();
        for (int i = 0; i < 10; i++) {
            Thread pro = new Thread(producer);
            pro.start();
            Thread con = new Thread(consumer);
            con.start();
        }
    }
}
