package main.java.com.introduction.thread.multi_thread.base;

import javax.sound.midi.Soundbank;

/**
 * @Author 程杰
 * @Date 2020/12/10 14:30
 * @Version 1.0
 */
public class ThreadStateDemo {

    public static void main(String[] args) throws InterruptedException {
        Test t = new Test();
        Thread thread1 = new Thread(() ->{
            t.testMethod();
        });

        Thread thread2 = new Thread(() ->{
            t.testMethod();
        });

        thread1.start();
        Thread.sleep(1000L);
        thread2.start();

        System.out.println(thread1.getName() + ":" + thread1.getState());
        System.out.println(thread2.getName() + ":" + thread2.getState());

    }
}

class Test{
    synchronized void testMethod() {
        try {
            Thread.sleep(2000L);
            System.out.println("执行啦"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
