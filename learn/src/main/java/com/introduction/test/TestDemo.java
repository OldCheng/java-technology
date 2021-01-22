package main.java.com.introduction.test;

import java.util.*;

/**
 * @Author 程杰
 * @Date 2020/12/3 20:43
 * @Version 1.0
 */
public class TestDemo {

    static int num = 5;

    public static double i = Math.random();

    public static void main(String[] args) {

        Random random = new Random(24);
        for(i=0;i<100;i++){
            System.out.println(random.nextInt(20));
        }


        TestDemo testDemo = new TestDemo();

        TestDemo testDemo1 = new TestDemo();
        TestDemo testDemo2 = new TestDemo();
        System.out.println(testDemo.num++);
        System.out.println(testDemo1.num);
        System.out.println(testDemo2.num);
        System.out.println("------"+num);

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
