package main.java.com.introduction.lambda;

import java.util.HashMap;
import java.util.Map;

public class TestToMap {
    public static void main(String[] args) {


        Map<String, String> map = new HashMap<>();
        map.put("aa", "AA");
        map.put("aa", "AA");
        map.put("bb", "BB");
        System.out.println(map.toString());

    }
}
