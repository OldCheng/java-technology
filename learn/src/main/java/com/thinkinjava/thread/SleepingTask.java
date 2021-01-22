package main.java.com.thinkinjava.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author 程杰
 * @Date 2021/1/20 16:04
 * @Version 1.0
 */
public class SleepingTask extends LiftOff {
    @Override
    public void run() {
        try{
            while(countDown-- > 0){
                System.out.print(status());
                TimeUnit.MILLISECONDS.sleep(10000);
            }
        }catch (InterruptedException e){
            System.err.println("  interraupted  ");
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }
}
