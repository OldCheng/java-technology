package main.java.com.introduction.thread.multi_thread.action;

import java.sql.SQLOutput;
import java.util.stream.IntStream;

/**
 * @Author 程杰
 * @Date 2020/12/10 15:00
 * @Version 1.0
 */
public class ThreadSync {
    private static Object obj = new Object();

    public static void main(String[] args) {

        Thread thread1 = new Thread(() ->{
           synchronized (obj){
               IntStream.range(0,100).forEach(i ->{
                   System.out.println("name:"+Thread.currentThread().getName()+"  count:"+i);
               });
           }
        });

        Thread thread2 = new Thread(() ->{
            synchronized (obj){
                IntStream.range(0,100).forEach(i ->{
                    System.out.println("name:"+Thread.currentThread().getName()+"  count:"+i);
                });
            }
        });

        thread1.start();

        thread2.start();
    }

}
