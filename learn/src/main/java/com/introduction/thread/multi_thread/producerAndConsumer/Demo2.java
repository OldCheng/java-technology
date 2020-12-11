package main.java.com.introduction.thread.multi_thread.producerAndConsumer;

import java.util.stream.IntStream;

/**
 * @Author 程杰
 * @Date 2020/12/10 17:13
 * @Version 1.0
 */
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        Resource1 resource1 = new Resource1();
        Thread producer = new Thread(() -> {
            IntStream.range(1,100).forEach(i ->resource1.set("面包"));
        });

        Thread consumer = new Thread(() -> {
            IntStream.range(1,100).forEach(i ->resource1.get());
        });

        producer.start();
        consumer.start();

    }

}
