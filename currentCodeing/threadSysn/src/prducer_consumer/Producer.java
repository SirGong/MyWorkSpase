package prducer_consumer;

public class Producer extends Thread {
    private Goods goods;
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);

            }catch (InterruptedException e){
                e.printStackTrace();
            }
            //对队列进行同步
            synchronized (TestPC.queue){
                goods = new Goods(1,"商品");
                //如果队列还有空间就继续生产
                if(TestPC.queue.size()<TestPC.MAX_POOL){
                    TestPC.queue.add(goods);
                    System.out.println(Thread.currentThread().getName()+"生产商品");
                }else {
                    //没有空间让生产者进行等待
                    try {
                        TestPC.queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
