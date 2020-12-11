package main.java.com.introduction.thread.multi_thread.producerAndConsumer;

/**
 * @Author 程杰
 * @Date 2020/12/10 17:07
 * @Version 1.0
 */
public class Resource1 {

    private String name;
    private int count = 0;
    public void set(String name){
        count++;
        this.name=name+"--"+count;
        System.out.println(Thread.currentThread().getName()+"...生产者..."+this.name);
    }
    public void get(){
        System.out.println(Thread.currentThread().getName()+"...消费者..."+this.name);
    }
}
