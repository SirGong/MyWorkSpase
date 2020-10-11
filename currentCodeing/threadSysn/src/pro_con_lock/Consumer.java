package pro_con_lock;

public class Consumer extends Thread {
    private Storage storage ;

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()){
            storage.consumer();
        }
    }
}
