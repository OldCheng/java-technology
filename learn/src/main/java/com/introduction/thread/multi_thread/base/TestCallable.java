package main.java.com.introduction.thread.multi_thread.base;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description
 * @Author 程杰
 * @Date 2021/3/25 16:07
 * @Version 1.0
 */
public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo callableDemo = new CallableDemo();
        FutureTask<String> futureTask = new FutureTask<String>(callableDemo);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
