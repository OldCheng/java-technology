package main.java.com.introduction.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 程杰
 * @Date 2020/12/3 20:43
 * @Version 1.0
 */
public class TestDemo {
    public static double i = Math.random();

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

        System.out.println("---------------------------------------");
        String str1 = "abc";

        String str2 = "abc";

        System.out.println(str1 == str2);

        String all = "abc2";

        String str3 = "abc" + 2;
        String str4 = "abc2";

        System.out.println(all == str3);

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        for (String s : list) {
            s = s +"d";
            System.out.println(s);
        }
        System.out.println(list);

    }
}
