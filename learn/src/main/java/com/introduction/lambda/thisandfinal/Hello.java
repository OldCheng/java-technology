package main.java.com.introduction.lambda.thisandfinal;

import static java.lang.System.out;

public class Hello {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                out.println(this);
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                out.println(toString());
            }
        };

        r1.run();
        r2.run();
    }

    @Override
    public String toString() {
        return "hello world!";
    }
}
