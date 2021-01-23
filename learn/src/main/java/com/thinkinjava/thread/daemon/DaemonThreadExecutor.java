package main.java.com.thinkinjava.thread.daemon;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author 程杰
 * @Date 2021/1/22 19:33
 * @Version 1.0
 */
public class DaemonThreadExecutor extends ThreadPoolExecutor {

    public DaemonThreadExecutor(){
        super(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),
                new DaemonThreadFactory());
    }

}
