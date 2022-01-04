package main.java.com.introduction.thread.produceandconsumer.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Clerk {

    private int product = -1;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();//建立condition对象

    public void setProduct(int product) throws InterruptedException {
        lock.lock();
        try{
            waitIfFull();
            this.product = product;
            System.out.printf("生产者设定 (%d)%n", this.product);
            condition.signal();// 用condition 的signal() 取代object 的 notify()
        } finally {
            lock.unlock();
        }
    }

    private void waitIfFull() throws InterruptedException {
        while (this.product != -1){
            condition.await();// 用condition 的await() 取代object 的 wait()
        }
    }

    public int getProduct() throws InterruptedException {
        lock.lock();
        try{
            waitIfEmpty();
            int p =  this.product;
            this.product = -1;
            System.out.printf("消费者取走(%d)%n", p);
            return p;
        }finally {
            lock.unlock();
        }
    }

    private void waitIfEmpty() throws InterruptedException {
        while(this.product == -1){
            condition.await();
        }
    }

}
