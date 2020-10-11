package pro_con_lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 仓库，负责存储商品
 */
public class Storage {
    private static int MAX_SIZE = 10;
    //用来模拟商品
    private Queue<Integer> queue = new LinkedList<>();
    private ReentrantLock lock = new ReentrantLock();
    private Condition fullCondition = lock.newCondition();
    private Condition emptyCondition = lock.newCondition();
    private int index = 0;

    //生产商品的方法
    public void produce() {
        try {
            lock.lock();
            if (queue.size() >= MAX_SIZE) {
                System.out.println("仓库已满，停止生产！");
                fullCondition.await();
            }
            Thread.sleep(500);
            queue.add(index++);
            System.out.println(index + "号产品生产了！");
            //发送信号量通知消费者进行消费
            emptyCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //消费商品的方法
    public void consumer() {
        try {
            lock.lock();
            if (queue.isEmpty()) {
                //没有商品，等待，通知生产
                System.out.println("仓库为空！");
                emptyCondition.await();
            }
            Thread.sleep(500);
            queue.poll();
            System.out.println("产品被消费了一个！仓库剩余量为：" + queue.size());
            //通知生产者生产
            fullCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
