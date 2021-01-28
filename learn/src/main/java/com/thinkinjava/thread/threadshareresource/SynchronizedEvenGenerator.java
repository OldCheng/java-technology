package main.java.com.thinkinjava.thread.threadshareresource;

import java.util.function.IntFunction;

/**
 * @Author 程杰
 * @Date 2021/1/26 10:45
 * @Version 1.0
 */
public class SynchronizedEvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    @Override
    public int next() {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
