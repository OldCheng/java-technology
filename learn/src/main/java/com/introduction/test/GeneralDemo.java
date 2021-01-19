package main.java.com.introduction.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 程杰
 * @Date 2020/12/24 15:53
 * @Version 1.0
 */
public class GeneralDemo {

    static class OOMObject { }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list.addAll(list1);
        List<String> list2 = new ArrayList<>();
        list2.add("3");
        list2.add("4");
        list.addAll(list2);
        list.forEach(System.out::println);

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

//        List<OOMObject> list7 = new ArrayList<OOMObject>();
//        while (true) { list7.add(new OOMObject()); }


    }
}
