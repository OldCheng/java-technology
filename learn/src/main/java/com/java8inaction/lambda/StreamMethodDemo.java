package main.java.com.java8inaction.lambda;

import main.java.com.introduction.entity.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author 程杰
 * @Date 2020/12/16 16:26
 * @Version 1.0
 */
public class StreamMethodDemo {
    public static void main(String[] args) {
        List<Dish> menu = Dish.getDish();

        System.out.println("----------------------匹配------------------------");
        // anyMatch: 流中是否有一个元素能匹配给定的布尔值 boolean
        if(menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }
        // allMatch: 流中的元素是否都能匹配条件
        boolean isHealthy = menu.stream()
                .allMatch(d -> d.getCalories() < 1000);
        System.out.println(isHealthy);

        // noneMatch: 流中的元素是否都不能匹配条件 和allMatch相对
        boolean isHealthy1 = menu.stream()
                .noneMatch(d -> d.getCalories() >= 1000);
        System.out.println(isHealthy1);

        System.out.println("----------------------查找------------------------");
        // findAny 方法将返回当前流中的任意元素
        Optional<Dish> dish =
                menu.stream()
                        .filter(Dish::isVegetarian)
                        .findAny();
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny().ifPresent(s -> System.out.println(s));

        menu.stream()
                .filter(Dish::isVegetarian)
                .findFirst().ifPresent(s -> System.out.println(s));

        System.out.println("----------------------归约------------------------");

        List<Integer> numbers = Arrays.asList(1,2,3);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        int count = menu.stream()
                .map(d -> 1)
                .reduce(0, (a, b) -> a + b);

        System.out.println("----------------------数值流------------------------");
        IntStream intStream
                = menu.stream()
                .mapToInt(Dish::getCalories);
        Stream<Integer> integerStream
                = menu.stream()
                .map(Dish::getCalories);
        menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        //将Stream转换为数值流
        IntStream intStream1 = menu.stream().mapToInt(Dish::getCalories);
        //将数值流转换为Stream
        Stream<Integer> stream = intStream.boxed();

        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        //如果没有最大值的话，显式提供一个默认最大值
        int max = maxCalories.orElse(1);

        //range是不包含结束值的，而rangeClosed则包含结束值
        IntStream.range(1, 6)
                .filter(n -> n % 2 == 0);
        IntStream.rangeClosed(1, 6)
                .filter(n -> n % 2 == 0);


        System.out.println(Math.sqrt(24*24+32*32));
        IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                                .mapToObj(b ->
                                        new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
                );


        Stream<int[]> stream1 = IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(1 * 1 + b * b) % 1 == 0)
                .mapToObj(b ->new int[]{1, b, (int) Math.sqrt(1 * 1 + b * b)});
    }
}
