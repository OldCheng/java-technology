package main.java.com.thinkinjava.thread.daemon;

import java.util.concurrent.ThreadFactory;

/**
 * @Author 程杰
 * @Date 2021/1/22 16:44
 * @Version 1.0
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
