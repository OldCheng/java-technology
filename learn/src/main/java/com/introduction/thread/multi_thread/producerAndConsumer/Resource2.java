package main.java.com.introduction.thread.multi_thread.producerAndConsumer;

/**
 * @Author 程杰
 * @Date 2020/12/10 17:07
 * @Version 1.0
 */
public class Resource2 {

    private String name;

    private int count;

    public synchronized void set(String name){
        count++;
        this.name=name+"--"+count;
        System.out.println(Thread.currentThread().getName()+"...生产者..."+this.name);
    }
    public synchronized void get(){
        System.out.println(Thread.currentThread().getName()+"...消费者..."+this.name);
    }
}
