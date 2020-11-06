package main.java.com.introduction.exception;

/**
 * @Description
 * @Author 程杰
 * @Date 2020/11/6 16:34
 * @Version 1.0
 */
public class ThrowDemo {
    public static void main(String[] args) {
        try {
            demoproc();
        } catch(NullPointerException e) {
            System.out.println("Recaught: " + e);
        }
        System.out.println("--------------------------------------");
        demoproc();

    }

    static void demoproc() {
        try {
            throw new NullPointerException("demo");
        } catch(NullPointerException e) {
            System.out.println("Caught inside demoproc.");
            throw e; // rethrow the exception
        }
    }

}
