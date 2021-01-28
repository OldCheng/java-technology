package main.java.com.thinkinjava.thread.exceptionthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author 程杰
 * @Date 2021/1/23 14:04
 * @Version 1.0
 */
public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        throw new ArithmeticException();
    }

    public static void main(String[] args) {

//        ExecutorService exec = Executors.newCachedThreadPool();
//        exec.execute(new ExceptionThread());
        /**
         * 由于线程的本质特性，使得你不能捕获从线程中逃逸的异常
         */
        try {
            ExecutorService exec1 = Executors.newCachedThreadPool();
            exec1.execute(new ExceptionThread());
        }catch (Exception e){

        }

    }
}
