package print_A_B_C;

/**
 * 使用wait函数和notifyAll函数实现交替打印 ABC
 */
public class Print_W_N {
    public static class ThreadPrint implements Runnable{
        private String name;
        private Object prev;
        private Object self;

        public ThreadPrint(String name, Object prev, Object self) {
            this.name = name;
            this.prev = prev;
            this.self = self;
        }

        @Override
        public void run() {
            int count = 10;
            while (count > 0){
                synchronized (prev){
                    synchronized (self){
                        System.out.println(name);
                        count--;
                        self.notifyAll();//唤醒其他线程竞争self锁，此时锁并没有立即释放
                    }
                    try {
                        if (count == 0){
                            //如果是最后一次打印，通过notifyAll操作释放对象锁
                            prev.notifyAll();
                        }else {
                            //立即释放prev锁，当前线程休眠等待唤醒
                            prev.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        ThreadPrint pa = new ThreadPrint("A",c,a);
        ThreadPrint pb = new ThreadPrint("B",a,b);
        ThreadPrint pc = new ThreadPrint("C",b,c);
        //添加sleep函数保证线程的启动顺序
        new Thread(pa).start();
        Thread.sleep(100);
        new Thread(pb).start();
        Thread.sleep(100);
        new Thread(pc).start();
        Thread.sleep(100);
    }
}
