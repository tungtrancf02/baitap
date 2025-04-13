package consumer;

public class ProductConsumerProblem {
    Store store;
    Producer producer;
    Consumer consumer;
    public ProductConsumerProblem() {
        store = new Store();
        producer = new Producer(store);
        consumer = new Consumer(store);
        producer.start();
        consumer.start();
    }
    public static void main(String[] args) {
        ProductConsumerProblem obj = new ProductConsumerProblem();
    }

}