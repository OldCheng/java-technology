package main.java.com.introduction.thread.multi_thread.producerAndConsumer;

/**
 * @Author 程杰
 * @Date 2020/12/10 17:13
 * @Version 1.0
 *
 * 使用synchronized + notify and wait(多消费者)
 */
public class Demo5 {
    public static void main(String[] args) throws InterruptedException {
        Resource3 resource3 = new Resource3();
        Thread producer = new Thread(() -> {
            while (true) {
                resource3.set("面包");
            }
        });

        Thread producer1 = new Thread(() -> {
            while (true) {
                resource3.set("面包");
            }
        });

        Thread consumer = new Thread(() -> {
            while (true){
                resource3.get();
            }
        });

        Thread consumer1 = new Thread(() -> {
            while (true){
                resource3.get();
            }
        });

        producer.start();
        producer1.start();
        consumer.start();
        consumer1.start();

    }

}
