package consumer;

public class Consumer extends Thread {
    Store store = null;

    public Consumer(Store store) {
        this.store = store;
    }

    public void run() {
        while(true) {
            try {
                long x = store.get();
                if (x > 0) System.out.println("-- Product " + x + " is bought.");
                else System.out.println("Consumer is waiting for new product.");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}