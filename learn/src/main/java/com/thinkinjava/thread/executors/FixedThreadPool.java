package main.java.com.thinkinjava.thread.executors;

import main.java.com.thinkinjava.thread.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author 程杰
 * @Date 2021/1/20 15:24
 * @Version 1.0
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
