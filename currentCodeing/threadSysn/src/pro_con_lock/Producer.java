package pro_con_lock;

public class Producer extends Thread {
    private Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()){
            storage.produce();
        }
    }
}
