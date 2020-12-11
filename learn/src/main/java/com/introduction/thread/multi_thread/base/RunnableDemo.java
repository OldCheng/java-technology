package main.java.com.introduction.thread.multi_thread.base;

/**
 * @Author 程杰
 * @Date 2020/12/10 10:40
 * @Version 1.0
 */
public class RunnableDemo implements Runnable {
    @Override
    public void run() {
        System.out.println("impl-thread----:"+ Thread.currentThread().getName());
    }
}
