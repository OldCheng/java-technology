package main.java.com.test;

/**
 * @Author 程杰
 * @Date 2021/1/28 11:00
 * @Version 1.0
 */
public class Test0 {

    public static void main(String[] args) {
        String map = "java.util.Map.";
        int i = map.lastIndexOf(".");
        System.out.println(i);
        System.out.println(map.substring(map.lastIndexOf(".") + 1));
        System.out.println(map.substring(0, map.lastIndexOf(".")));
    }
}
