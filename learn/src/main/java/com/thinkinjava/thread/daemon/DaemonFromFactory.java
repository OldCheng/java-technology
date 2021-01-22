package main.java.com.thinkinjava.thread.daemon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author 程杰
 * @Date 2021/1/22 16:50
 * @Version 1.0
 */
public class DaemonFromFactory implements Runnable {
    @Override
    public void run() {
        try {
            while(true){
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println(Thread.currentThread() + "   " + this);
            }
        }catch (InterruptedException e){
            System.out.println("interrupted--------------");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            exec.execute(new DaemonFromFactory());
        }
        System.out.println("all daemons start");
        TimeUnit.MILLISECONDS.sleep(5000);
    }
}
