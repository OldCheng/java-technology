package main.java.com.introduction.thread.multi_thread.producerAndConsumer;

/**
 * @Author 程杰
 * @Date 2020/12/10 17:13
 * @Version 1.0
 *
 * 使用synchronized + notify and wait(多消费者)
 */
public class Demo6 {
    public static void main(String[] args) throws InterruptedException {
        Resource4 resource4 = new Resource4();
        Thread producer = new Thread(() -> {
            while (true) {
                resource4.set("面包");
            }
        });

        Thread producer1 = new Thread(() -> {
            while (true) {
                resource4.set("面包");
            }
        });

        Thread consumer = new Thread(() -> {
            while (true){
                resource4.get();
            }
        });

        Thread consumer1 = new Thread(() -> {
            while (true){
                resource4.get();
            }
        });

        producer.start();
        producer1.start();
        consumer.start();
        consumer1.start();

    }

}
