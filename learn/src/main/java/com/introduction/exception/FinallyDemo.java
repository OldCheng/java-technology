package main.java.com.introduction.exception;

/**
 * @Description
 * @Author 程杰
 * @Date 2020/11/6 16:53
 * @Version 1.0
 */
public class FinallyDemo {
    /**Through an exception out of the method.*/
    static void procA() {
        try {
            System.out.println("inside procA");
            throw new RuntimeException("demo");
        } finally {
            System.out.println("procA's finally");
        }
    }

    /**Return from within a try block.*/
    static void procB() {
        try {
            System.out.println("inside procB");
            return;
        } finally {
            System.out.println("procB's finally");
        }
    }
/**Execute a try block normally.*/
    static void procC() {
        try {
            System.out.println("inside procC");
        } finally {
            System.out.println("procC's finally");
        }
    }

    public static void main(String[] args) {
        try {
            procA();
        } catch (Exception e) {
            System.out.println("Exception caught");
        }
        System.out.println("------------");
        procB();
        System.out.println("------------");
        procC();
    }
}
