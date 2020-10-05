package prducer_consumer;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class TestPC {
    public static final int MAX_POOL = 10;
    public static final int MAX_PRODUCER = 5;
    public static final int MAX_CONSUMER = 6;
    public static Queue<Goods> queue = new ArrayBlockingQueue<>(MAX_POOL);

    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        for (int i = 0; i < MAX_PRODUCER; i++) {
            Thread threadA = new Thread(producer, "生产者线程" + i);
            threadA.start();
        }

        for (int i = 0; i < MAX_CONSUMER; i++) {
            Thread threadB = new Thread(consumer, "消费者线程" + i);
            threadB.start();
        }
    }
}
