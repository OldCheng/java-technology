package main.java.com.java8inaction.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author 程杰
 * @Date 2021/1/8 15:27
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        int x = 3;

        System.out.println(x++);
        System.out.println(++x);
        String sss = "h t t p s : / / w w w . z h i h u . c o m / q u e s t i o n / 5 11 0 2 3 0 8 / a n s w e r / 1 2 4 4 4 111 5 ";
        System.out.println(sss.replace(" ", ""));
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.add("e");

        List<String> list2 = new ArrayList<>();
        list2.add("d");
        list2.add("e");
        list2.add("f");
        list2.add("g");

        List<String> collect = list1.stream().filter(l1 -> list1.stream().anyMatch(l2 -> list2.contains(l1))).collect(Collectors.toList());


    }
}
