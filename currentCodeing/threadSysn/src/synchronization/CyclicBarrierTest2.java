package synchronization;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 每个任务有三个阶段，阶段1，阶段2，阶段3
 * 每个线程要串行的执行阶段1，阶段2，阶段2
 * 多个线程同时执行该任务时，只有每个任务的阶段1都执行完之后，才能执行阶段2，每个任务的阶段2全部执行完之后才能执行阶段3
 */
public class CyclicBarrierTest2 {
    private static CyclicBarrier  cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //创建线程1
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread()+"step1");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread()+"step2");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread()+"step3");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //创建线程2
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread()+"step1");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread()+"step2");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread()+"step3");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.shutdown();
    }
}
