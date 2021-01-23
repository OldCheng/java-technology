package main.java.com.thinkinjava.thread.daemon;

import java.util.concurrent.TimeUnit;

/**
 * @Author 程杰
 * @Date 2021/1/22 19:56
 * @Version 1.0
 */
public class ADaemon implements Runnable {


    @Override
    public void run() {
        try {
            System.out.println("Starting ADaemon----------");
            TimeUnit.MILLISECONDS.sleep(5000);
        }catch (InterruptedException e){
            System.out.println("Exiting via InterruptedException");
        }finally {
            System.out.println(" this should always run? ");
        }
    }

}
