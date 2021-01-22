package main.java.com.thinkinjava.thread.executors;

import main.java.com.thinkinjava.thread.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author 程杰
 * @Date 2021/1/20 15:15
 * @Version 1.0
 */
public class CacheThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 2; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
