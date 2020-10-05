package prducer_consumer;

public class Consumer extends Thread {
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (TestPC.queue){
                if(!TestPC.queue.isEmpty()){//队列中有商品
                    TestPC.queue.poll();
                    System.out.println(Thread.currentThread().getName()+"消费商品");
                }else {
                    //唤醒生产者继续生产
                    TestPC.queue.notify();
                }
            }
        }
    }
}
