package main.java.com.introduction.thread.multi_thread.action;

import java.util.stream.IntStream;

/**
 * @Author 程杰
 * @Date 2020/12/10 15:22
 * @Version 1.0
 */
public class Signal {

    private static int signal = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() ->{
            while (signal < 5) {
                if (signal % 2 == 0) {
                    System.out.println(Thread.currentThread().getName()+ ": " + signal);
                    signal++;
                }
            }
        });

        Thread thread2 = new Thread(() ->{
            while (signal < 5) {
                if (signal % 2 == 1) {
                    System.out.println(Thread.currentThread().getName()+ ": " + signal);
                    signal++;
                }
            }
        });

        thread1.start();

        thread2.start();
    }
}
