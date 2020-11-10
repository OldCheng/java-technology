package main.java.com.introduction.exception;

/**
 * @Description
 * @Author 程杰
 * @Date 2020/11/6 17:02
 * @Version 1.0
 */
public class MyException extends Exception {
    private int detail;
    MyException(int a) {
        detail = a;
    }

    @Override
    public String toString() {
        return "MyException[" + detail + "]";
    }
}
