package main.java.com.java8inaction.lambda;

import main.java.com.introduction.entity.CaloricLevel;
import main.java.com.introduction.entity.Dish;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

/**
 * @Author 程杰
 * @Date 2020/12/17 17:57
 * @Version 1.0
 */
public class StreamCollectorsDemo {
    public static void main(String[] args) {
        List<Dish> menu = Dish.getDish();
        //数一数菜单里有多少种菜
        long howManyDishes = menu.stream().collect(Collectors.counting());
        long howManyDishes1 = menu.stream().count();

        //Collectors.maxBy和Collectors.minBy，来计算流中的最大或最小值。
        // 这两个收集器接收一个Comparator参数来比较流中的元素。
        Comparator<Dish> dishCaloriesComparator =
                comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish =
                menu.stream()
                        .collect(maxBy(dishCaloriesComparator));
        //菜单列表的总热量
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        //平均数
        double avgCalories =
                menu.stream().collect(averagingInt(Dish::getCalories));

        //通过一次summarizing操作你可以就数出菜单中元素的个数，并得
        //到菜肴热量总和、平均值、最大值和最小值
        //结果:IntSummaryStatistics{count=9, sum=4300, min=120,average=477.777778, max=800}
        IntSummaryStatistics menuStatistics =
                menu.stream().collect(summarizingInt(Dish::getCalories));

        //连接字符串
        String shortMenu = menu.stream().map(Dish::getName).collect(joining());
        String shortMenu1 = menu.stream().map(Dish::getName).collect(joining(", "));

        //分组
        Map<Dish.Type, List<Dish>> dishesByType =
                menu.stream().collect(groupingBy(Dish::getType));

        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
                menu.stream().collect(
                        groupingBy(Dish::getType,
                                groupingBy(dish -> {
                                    if (dish.getCalories() <= 400) {
                                        return CaloricLevel.DIET;
                                    } else if (dish.getCalories() <= 700) {
                                        return CaloricLevel.NORMAL;
                                    }else {
                                        return CaloricLevel.FAT;
                                    }
                                } )
                        )
                );

        Map<Dish.Type, Long> typesCount = menu.stream().collect(
                groupingBy(Dish::getType, counting()));

        Map<Dish.Type, Optional<Dish>> mostCaloricByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                maxBy(comparingInt(Dish::getCalories))));

        //查找每个子组中热量最高的Dish
        Map<Dish.Type, Dish> mostCaloricByType1 =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                collectingAndThen(
                                        maxBy(comparingInt(Dish::getCalories)),
                                        Optional::get)));

    }
}
