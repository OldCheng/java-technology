package main.java.com.thinkinjava.thread.daemon;

import javax.sound.midi.Soundbank;


/**
 * @Author 程杰
 * @Date 2021/1/22 19:38
 * @Version 1.0
 */
public class Daemon implements Runnable {

    private Thread[] t = new Thread[10];

    @Override
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn" + i + " started. " );
        }

        for (int i = 0; i < t.length; i++) {
            System.out.println("t[ "+ i + "].isDaemon() = " + t[i].isDaemon() +" ,");
        }

        while (true){
            Thread.yield();
        }
        
    }
}
