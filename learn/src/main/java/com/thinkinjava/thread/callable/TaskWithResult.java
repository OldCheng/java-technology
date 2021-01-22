package main.java.com.thinkinjava.thread.callable;

import java.util.concurrent.Callable;

/**
 * @Author 程杰
 * @Date 2021/1/20 15:33
 * @Version 1.0
 */
public class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id){
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of taskWithResult : "+ id;
    }
}
