package main.java.com.thinkinjava.thread.method;

/**
 * @Author 程杰
 * @Date 2021/1/23 10:19
 * @Version 1.0
 */
public class Joiner extends Thread {

    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        }catch (InterruptedException e){
            System.out.println(" interrupted  ---- ");
        }
        System.out.println(getName() + " join completed --");
    }
}
