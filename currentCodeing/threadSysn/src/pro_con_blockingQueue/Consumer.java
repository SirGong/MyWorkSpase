package pro_con_blockingQueue;

public class Consumer extends Thread {
    private Storage storage;

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        storage.consumer();
    }
}
