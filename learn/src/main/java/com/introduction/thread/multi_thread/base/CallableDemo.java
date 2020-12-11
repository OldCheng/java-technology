package main.java.com.introduction.thread.multi_thread.base;

import java.util.concurrent.Callable;

/**
 * @Author 程杰
 * @Date 2020/12/10 11:00
 * @Version 1.0
 */
public class CallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "callable-result";
    }
}
