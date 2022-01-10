package main.java.com.introduction.lambda.overview;

import java.util.Arrays;
import java.util.Comparator;

public class Demo {
    public static void main(String[] args) {
        String[] names = {"Justin","caterpillar","Bush"};
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        //----------------------------------
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
        Arrays.sort(names,comparator);
        //----------------------------------
        Comparator<String> comparator1 = (String o1, String o2) -> o1.length() - o2.length();
        Comparator<String> comparator2 = (o1, o2) -> o1.length() - o2.length();
        Comparator<String> comparator3 = (o1, o2) -> { return o1.length() - o2.length();};

    }
}
