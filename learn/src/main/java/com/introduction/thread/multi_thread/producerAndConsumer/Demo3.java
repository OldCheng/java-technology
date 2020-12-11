package main.java.com.introduction.thread.multi_thread.producerAndConsumer;

/**
 * @Author 程杰
 * @Date 2020/12/10 17:13
 * @Version 1.0
 *
 * 使用synchronized(单消费者但是会出现消费同一个资源)
 */
public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        Resource2 resource2 = new Resource2();
        Thread producer = new Thread(() -> {
            while (true) {
                resource2.set("面包");
            }
        });

        Thread consumer = new Thread(() -> {
            while (true){
                resource2.get();
            }
        });

        producer.start();
        consumer.start();

    }

}
