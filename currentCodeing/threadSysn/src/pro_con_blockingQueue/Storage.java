package pro_con_blockingQueue;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Storage {
    //容量为10的队列作为缓存
    private LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue(10);
    int number = 0;

    public void produce() {
        while (true){
            try {
                Thread.sleep(500);
                //容量满了时也自动阻塞
                queue.put(number++);
                System.out.println("生产了一个产品！容量为：" + queue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void consumer() {
        while (true){
            try {
                Thread.sleep(800);
                //take方法容量为空时自动阻塞
                System.out.println("消费了产品"+queue.take()+",容量为：" + queue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
