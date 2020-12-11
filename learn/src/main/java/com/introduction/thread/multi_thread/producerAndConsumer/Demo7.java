package main.java.com.introduction.thread.multi_thread.producerAndConsumer;

import java.util.stream.IntStream;

/**
 * @Author 程杰
 * @Date 2020/12/10 17:13
 * @Version 1.0
 *
 * 使用synchronized + notify and wait(多消费者)
 */
public class Demo7 {
    public static void main(String[] args) throws InterruptedException {
        Resource5 resource5 = new Resource5();
        Thread producer = new Thread(() -> {
            IntStream.range(0,10).forEach(i->resource5.set("面包"));
        },"   thread==producer111");

        Thread producer1 = new Thread(() -> {
            IntStream.range(0,10).forEach(i->resource5.set("面包"));
        },"   thread==producer222");

        Thread consumer = new Thread(() -> {
                IntStream.range(0,10).forEach(i->resource5.get());
        },"   thread==consumer888");

        Thread consumer1 = new Thread(() -> {
            IntStream.range(0,10).forEach(i->resource5.get());
        },"   thread==consumer999");

        producer.start();
        producer1.start();
        consumer.start();
        consumer1.start();

    }

}
