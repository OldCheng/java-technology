package main.java.com.introduction.thread.multi_thread.base;

import javax.sound.midi.Soundbank;
import java.util.stream.IntStream;

/**
 * @Author 程杰
 * @Date 2020/12/10 11:25
 * @Version 1.0
 */
public class ThreadGroupDemo {
    public static void main(String[] args) {
        Thread testThread = new Thread(() -> {
            System.out.println("testThread当前线程组名字：" +
                    Thread.currentThread().getThreadGroup().getName());
            System.out.println("testThread线程名字：" +
                    Thread.currentThread().getName());
        });

        testThread.start();
        System.out.println("执行main所在线程的线程组名字： " + Thread.currentThread().getThreadGroup().getName());
        System.out.println("执行main方法线程名字：" + Thread.currentThread().getName());

        System.out.println("------------------------------------------------");
        Thread a = new Thread();
        System.out.println("我是默认线程优先级："+a.getPriority());
        Thread b = new Thread();
        b.setPriority(10);
        System.out.println("我是设置过的线程优先级："+b.getPriority());

        System.out.println("------------------------------------------------");

        IntStream.range(1, 10).forEach(i -> {
            Thread thread = new Thread(() -> {
                System.out.println(String.format("当前执行的线程是：%s，优先级：%d",
                        Thread.currentThread().getName(),
                        Thread.currentThread().getPriority()));
            });
            thread.setPriority(i);
            thread.start();
        });

        System.out.println("-----------------------------------");
        ThreadGroup threadGroup = new ThreadGroup("t1");
        threadGroup.setMaxPriority(6);
        Thread thread = new Thread(threadGroup,"thread");
        thread.setPriority(9);
        System.out.println("我是线程组的优先级"+threadGroup.getMaxPriority());
        System.out.println("我是线程的优先级"+thread.getPriority());
    }
}
