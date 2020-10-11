package pro_con_blockingQueue;

public class Producer  extends Thread{
    private Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        storage.produce();
    }
}
