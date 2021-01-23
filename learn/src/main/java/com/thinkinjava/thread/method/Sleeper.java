package main.java.com.thinkinjava.thread.method;

/**
 * @Author 程杰
 * @Date 2021/1/23 10:13
 * @Version 1.0
 */
public class Sleeper extends Thread {

    private int duration;

    public Sleeper(String name, int sleepTime){
        super(name);
        this.duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            System.out.println(" 线程名称：" + Thread.currentThread().getName());
            sleep(duration);
        }catch (InterruptedException e){
            System.out.println(getName() + " was interrupted ." + "isInterrupted() " + isInterrupted());
            return;
        }
        System.out.println(getName()  +  " has awakened ");
    }
}
