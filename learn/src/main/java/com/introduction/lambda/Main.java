package main.java.com.introduction.lambda;

import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        IntStream ints = random.ints(1, 10);

        ints.forEach(System.out::println);

    }
}
