package main.java.com.thinkinjava.genericity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author 程杰
 * @Date 2021/1/19 11:25
 * @Version 1.0
 */
public class Demo {
    public static void main(String[] args) {
        //Map<String, List<String>> map = New.map();
        //System.out.println(map.getClass().getName());
f(New.map());

        String [] strings = new String[4];
        System.out.println(strings.length);

        Integer [] [] integers = new Integer[3][];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = new Integer[4];
            for (int j = 0; j < integers[i].length; j++) {
                integers[i][j] = i * j;
            }
        }
        System.out.println(Arrays.deepToString(integers));
    }

    public static void f(Map<String, List<String>> smap){}

    public static void f(String smap){}
}
