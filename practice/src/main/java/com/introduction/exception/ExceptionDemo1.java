package main.java.com.introduction.exception;

/**
 * @Description
 * @Author 程杰
 * @Date 2020/11/6 15:58
 * @Version 1.0
 */
public class ExceptionDemo1 {
    public static void main(String[] args) {
        int d, a;
        try { // monitor a block of code.
            d = 0;
            a = 42 / d;
            System.out.println("This will not be printed.");
        } catch (ArithmeticException e) { // catch divide-by-zero error
            System.out.println("========"+e);
            System.out.println("Division by zero.");
        }
        System.out.println("After catch statement.");
    }
}
