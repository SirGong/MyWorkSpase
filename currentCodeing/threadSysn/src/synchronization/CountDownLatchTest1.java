package synchronization;

import java.util.concurrent.CountDownLatch;


public class CountDownLatchTest1 {
    //创建一个CountDownLatch实例，传入的参数为线程数
    private static volatile CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
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

        Thread threadTwo = new Thread(new Runnable() {
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

        threadOne.start();
        threadTwo.start();

        System.out.println("等待子线程执行完毕！");

        //等待子线程执行完毕后返回
        countDownLatch.await();

        System.out.println("所有线程执行完毕！");
    }
}
