package main.java.com.thinkinjava.thread.daemon;


import java.util.concurrent.TimeUnit;

/**
 * @Author 程杰
 * @Date 2021/1/22 19:49
 * @Version 1.0
 */
public class Daemons{

    public static void main(String[] args) throws InterruptedException {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();

        System.out.println("d.isDaemon() = " + d.isDaemon() + ", ");

        TimeUnit.MILLISECONDS.sleep(5000);
    }

}
