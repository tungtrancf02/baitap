package banhmi;



public class ShopBanhMy {
    private int banhmy = 0;

    public synchronized int khaylambanh() throws InterruptedException {
        while (banhmy >= 5) {
            System.out.println("Khay đầy, đợi người mua...");
            wait();
        }
        System.out.println("Bánh mỳ đã hết, đang nạp lại khay...");
        banhmy++;
        Thread.sleep(1000);
        System.out.println("Đã xong 1 ổ, số lượng hiện tại: " + banhmy);
        notifyAll();
        return banhmy;
    }

    public synchronized void muabanhmy() throws InterruptedException {
        while (banhmy <= 0) {
            System.out.println("Hết hàng, đợi làm bánh...");
            wait();
        }
        banhmy--;
        System.out.println(Thread.currentThread().getName() + " đã mua 1 ổ");
        System.out.println("Số lượng bánh: " + banhmy);
        Thread.sleep(3000);
        notifyAll();
    }

    public Runnable nguoimua() {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        muabanhmy();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public Runnable nguoilambanh() {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        khaylambanh();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public static void main(String[] args) {
        ShopBanhMy shop = new ShopBanhMy();
        Thread producer = new Thread(shop.nguoilambanh(), "Người làm bánh");
        Thread consumer = new Thread(shop.nguoimua(), "Người mua");
        producer.start();
        consumer.start();
    }
}