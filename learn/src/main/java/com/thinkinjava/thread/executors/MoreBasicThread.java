package main.java.com.thinkinjava.thread.executors;

import main.java.com.thinkinjava.thread.LiftOff;

/**
 * @Author 程杰
 * @Date 2021/1/20 15:00
 * @Version 1.0
 */
public class MoreBasicThread {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("waiting for liftoff");
    }
}
