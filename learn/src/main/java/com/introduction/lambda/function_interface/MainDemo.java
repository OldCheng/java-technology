package main.java.com.introduction.lambda.function_interface;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * @Description
 * @Author 程杰
 * @Date 2020/11/12 19:46
 * @Version 1.0
 */
public class MainDemo {
    public static void main(String[] args) {

        Predicate<Integer> predicate = x -> x > 5;

        BinaryOperator<Long> addLongs = (x, y) -> x + y;
        System.out.println(addLongs);
    }
}
