package main.java.com.thinkinjava.thread.daemon;

import java.util.concurrent.TimeUnit;

/**
 * 后台线程
 * @Author 程杰
 * @Date 2021/1/20 17:24
 * @Version 1.0
 */
public class SimpleDaemons implements Runnable{

    @Override
    public void run() {
        try {
            while(true){
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println(Thread.currentThread() +"   " + this);
            }
        }catch (Exception e){
            System.out.println("sleep  interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SimpleDaemons());
            thread.setDaemon(true);
            thread.start();
        }
        System.out.println("all  daemon started");
        TimeUnit.MILLISECONDS.sleep(5000);
    }
}
