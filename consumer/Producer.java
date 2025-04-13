package consumer;

public class Producer extends Thread{
    Store store = null;
    long idx = 1;
    public Producer(Store store) {
        this.store = store;
    }
    public void run() {
        while(true) {
            try {
                boolean result = store.put(idx);
                if (result == true) System.out.println("** Product " + (idx++) + " is made.");
                else System.out.println("Store is full");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}