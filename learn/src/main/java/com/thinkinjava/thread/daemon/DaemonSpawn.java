package main.java.com.thinkinjava.thread.daemon;

/**
 * @Author 程杰
 * @Date 2021/1/22 19:43
 * @Version 1.0
 */
public class DaemonSpawn implements Runnable {
    @Override
    public void run() {
        while (true){
            Thread.yield();
        }
    }
}
