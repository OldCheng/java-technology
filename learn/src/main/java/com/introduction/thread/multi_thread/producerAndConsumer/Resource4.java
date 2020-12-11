package main.java.com.introduction.thread.multi_thread.producerAndConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author 程杰
 * @Date 2020/12/10 17:07
 * @Version 1.0
 */
public class Resource4 {

    private String name;

    private int count = 1;

    private boolean flag;

    private Lock lock = new ReentrantLock();

    private Condition producer_con = lock.newCondition();

    private Condition consumer_con = lock.newCondition();

    public void set(String name) {
        lock.lock();
        try {
            while (flag) {
                try {
                    //把该线程加入到生产者线程池
                    producer_con.await();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            this.name = name + "--" + count;
            count++;
            System.out.println(Thread.currentThread().getName() + "...生产者..." + this.name);
            flag = true;
            //只唤醒一个消费者
            consumer_con.signal();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        lock.lock();
        try {
            while (!flag) {
                try {
                    //把该线程加入到消费者线程池
                    consumer_con.await();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "...消费者..." + this.name);
            flag = false;
            //只唤醒一个生产者
            producer_con.signal();
        } finally {
            lock.unlock();
        }
    }
}
