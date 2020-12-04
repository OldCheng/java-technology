package main.java.com.introduction.test;

/**
 * @Author 程杰
 * @Date 2020/12/3 20:43
 * @Version 1.0
 */
public class TestDemo {
    public static void main(String[] args) {
        String a = "hello2";
        final String b = "hello";
        String c = "hello";
        String d = b + 2;
        String e = c + 2;
        System.out.println((a.equals(d)));
        System.out.println((a.equals(e)));
        System.out.println("===============");
        System.out.println((a == d));
        System.out.println((a == e));
    }
}
