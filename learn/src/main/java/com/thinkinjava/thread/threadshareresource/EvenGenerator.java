package main.java.com.thinkinjava.thread.threadshareresource;

/**
 * @Author 程杰
 * @Date 2021/1/26 10:25
 * @Version 1.0
 */
public class EvenGenerator extends IntGenerator {

    private int currentEvenValue;

    @Override
    public int next() {
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }

}
