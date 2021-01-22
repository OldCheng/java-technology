package main.java.com.thinkinjava.thread;

/**
 * @Author 程杰
 * @Date 2021/1/20 14:58
 * @Version 1.0
 */
public class BasicThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new LiftOff());
        thread.start();
        System.out.println("waiting for liftoff");
    }
}
