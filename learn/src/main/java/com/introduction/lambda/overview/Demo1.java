package main.java.com.introduction.lambda.overview;

import java.util.Arrays;
import java.util.Comparator;

public class Demo1 {
    public static void main(String[] args) {
        String[] names = {"Justin","caterpillar","Bush"};
        Arrays.sort(names, (name1, name2) -> StringOrder.byLength(name1, name2));
        Arrays.sort(names, StringOrder::byLength);


    }
}
