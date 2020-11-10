package main.java.com.introduction.exception;

/**
 * @Description
 * @Author 程杰
 * @Date 2020/11/6 16:51
 * @Version 1.0
 */
public class ThrowDemo2 {
    public static void main(String[] args) {
        try {
            int i = 9/0;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("------------");
            e.printStackTrace();
            System.out.println("------------");
        }finally {
            System.out.println("--------finally---------");
        }
        System.out.println("----end----");
    }
}
