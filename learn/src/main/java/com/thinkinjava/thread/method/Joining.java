package main.java.com.thinkinjava.thread.method;

/**
 * @Author 程杰
 * @Date 2021/1/23 10:22
 * @Version 1.0
 */
public class Joining {

    public static void main(String[] args) {
        Sleeper sleeper = new Sleeper("sleepy", 5000),
                grumpy = new Sleeper("grumpy", 5000);

        Joiner dopey = new Joiner("dopey", sleeper),
                doc = new Joiner("doc", grumpy);
        grumpy.interrupt();
    }

}
