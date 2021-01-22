package main.java.com.thinkinjava.thread;

/**
 * @Author 程杰
 * @Date 2021/1/20 14:55
 * @Version 1.0
 */
public class MainThread {
    public static void main(String[] args) {
        LiftOff liftOff = new LiftOff();
        liftOff.run();
    }
}
