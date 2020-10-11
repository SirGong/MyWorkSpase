package print_A_B_C;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Print_AtomicInteger {
    private AtomicInteger camp = new AtomicInteger(0);
    private static final int MAX_VALUE = 3 * 10;

    private class ThreadA implements Runnable {
        @Override
        public void run() {
            while (camp.get() < MAX_VALUE - 1) {
                if (camp.get() % 3 == 0) {
                    System.out.println("A");
                    //让值自增1
                    camp.getAndIncrement();
                }
            }
        }
    }

    private class ThreadB implements Runnable {
        @Override
        public void run() {
            while (camp.get() < MAX_VALUE) {
                if (camp.get() % 3 == 1) {
                    System.out.println("B");
                    //让值自增1
                    camp.getAndIncrement();
                }
            }
        }
    }

    private class ThreadC implements Runnable {
        @Override
        public void run() {
            while (camp.get() < MAX_VALUE) {
                if (camp.get() % 3 == 2) {
                    System.out.println("C");
                    //让值自增1
                    camp.getAndIncrement();
                }
            }
        }
    }

    public static void main(String[] args) {
        Print_AtomicInteger printABC = new Print_AtomicInteger();
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(printABC.new ThreadA());
        service.execute(printABC.new ThreadB());
        service.execute(printABC.new ThreadC());

        service.shutdown();
    }
}
