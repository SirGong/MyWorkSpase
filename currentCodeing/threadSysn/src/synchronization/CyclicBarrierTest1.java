package synchronization;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest1 {
    //创建一个CyclicBarrier实例线程，当所有的子线程都达到一个屏障之后会运行该线程
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
        @Override
        public void run() {
            System.out.println(Thread.currentThread()+"子线程已经达到屏障点！");
        }
    });

    public static void main(String[] args) {
        //创建一个线程个数固定为2的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //创建第一个子线程1
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread()+"子线程1");
                    System.out.println(Thread.currentThread()+"子线程1进入barrier！");

                    //子线程1的屏障点
                    cyclicBarrier.await();

                    System.out.println(Thread.currentThread()+"子线程1结束Barrier！");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //创建第一个子线程2
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread()+"子线程2");
                    System.out.println(Thread.currentThread()+"子线程2进入barrier！");
                    //子线程2的屏障点
                    cyclicBarrier.await();

                    System.out.println(Thread.currentThread()+"子线程2结束Barrier！");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //关闭线程池
        executorService.shutdown();
    }
}
