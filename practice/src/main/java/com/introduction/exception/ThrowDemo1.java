package main.java.com.introduction.exception;

/**
 * @Description
 * @Author 程杰
 * @Date 2020/11/6 16:34
 * @Version 1.0
 */
public class ThrowDemo1 {
    static void throwOne() {
        System.out.println("Inside throwOne.");
        try {
            throw new IllegalAccessException("demo");
        } catch (IllegalAccessException e) {
            System.out.println("------------");
            e.printStackTrace();
            System.out.println("------------");
        }
        System.out.println("----end----");
    }
    public static void main(String args[]) {
        throwOne();
    }

}
