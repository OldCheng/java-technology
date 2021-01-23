package main.java.com.thinkinjava.thread.daemon;

import java.util.concurrent.TimeUnit;

/**
 * 后台线程 : 是指程序在运行的时候后台提供一种通用服务的线程，
 *          并且这种线称并不属于程序中不可或缺的部分，因此当所有的非后台线程结束时
 *          程序也就终止，同事会杀死进程中所有的后台线程。反过来说，只要有任何非后台线程
 *          还在运行，程序就不会终止。比如main方法就是非后台线程
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
