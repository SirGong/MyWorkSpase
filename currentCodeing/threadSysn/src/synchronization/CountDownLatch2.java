package synchronization;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatch2 {
    private static volatile CountDownLatch countDownLatch = new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {
        //创建线程池管理线程
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //将线程1添加到线程池中
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("线程1执行完毕！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            }
        });

        //将线程二添加到线程池中
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("线程2执行完毕！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            }
        });

        System.out.println("等待子线程执行完毕！");

        //等待子线程执行完毕后返回
        countDownLatch.await();

        System.out.println("所有线程执行完毕！");
        //关闭线程池
        executorService.shutdown();
    }
}
