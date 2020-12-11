package main.java.com.introduction.thread.multi_thread.base;

import java.util.concurrent.*;

/**
 * @Author 程杰
 * @Date 2020/12/10 10:41
 * @Version 1.0
 */
public class Demo {
    public static void main(String[] args) throws Exception {

        System.out.println(Thread.currentThread().getName());

        //extends Thread
        ThreadDemo td = new ThreadDemo();
        td.start();
        System.out.println("------------1---------------");

        //impl Runnable
        Thread t = new Thread(new RunnableDemo());
        t.start();

        System.out.println("-------------2-------------------");
        CallableDemo callableDemo = new CallableDemo();
        //callable
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<String> result = executor.submit(callableDemo);
        // 注意调用get方法会阻塞当前线程，直到得到结果。
        // 所以实际编码中建议使用可以设置超时时间的重载get方法。
        System.out.println(result.get());

        System.out.println("-------------3-------------------");
        // FutureTask
        ExecutorService executor1 = Executors.newCachedThreadPool();
        FutureTask<String> futureTask = new FutureTask<String>(callableDemo);
        executor.submit(futureTask);
        System.out.println(futureTask.get());
    }
}
