package main.java.com.java8inaction.lambda;

import main.java.com.introduction.entity.Dish;
import main.java.com.introduction.entity.Letter;
import main.java.com.introduction.entity.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @Author 程杰
 * @Date 2020/12/14 14:12
 * @Version 1.0
 */
public class ActionDemo {


    public static void main(String[] args) {
        List<Person> personList = getPersonList();

        Comparator<Person> comparator = Comparator.comparing(Person::getSalary);
        //排序
        personList.sort(comparator);
        //反向排序
        personList.sort(comparator.reversed());

        //多条件组合排序
        personList.sort(comparator.reversed().thenComparing(Person::getAge));

        System.out.println("----------------函数复合-------------------------------------");
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline
                = addHeader.andThen(Letter::checkSpelling)
                .andThen(Letter::addFooter);
        System.out.println(transformationPipeline.apply("labdalabdalabdalabda"));

        System.out.println("-----------------------------------------------------");
        List<Dish> menu = getDish();
        List<String> lowCaloricDishesName =
                menu.parallelStream()
                        .filter(d -> d.getCalories() < 400)
                        .sorted(Comparator.comparing(Dish::getCalories))
                        .map(Dish::getName)
                        .collect(toList());

        System.out.println("-----------------------map----flatMap--------------------------");
        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
        Arrays.stream(arrayOfWords).map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList());
        List<String[]> collect = Arrays.asList(arrayOfWords).stream().map(word -> word.split(""))
                .distinct()
                .collect(toList());
       // collect.forEach(i-> Arrays.asList(i).forEach(System.out::println));
        Arrays.stream(arrayOfWords).map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("-----------------------map----flatMap----练习----------------------");
        //给定两个数字列表，如何返回所有的数对呢？例如，给定列表[1, 2, 3]和列表[3, 4]，应
        //该返回[(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]。为简单起见，你可以用有两个元素的数组来代
        //表数对。
        List<Integer> number1 = Arrays.asList(1,2,3);
        Stream<Integer> integerStream = number1.stream().map(i -> i.intValue()).map(s -> s.intValue());
        List<Integer> number2 = Arrays.asList(3,4);
        List<int[]> collect1 = number1.stream()
                .flatMap(i -> number2.stream()
                        .map(j -> new int[]{i, j}
                        )
                ).collect(toList());

        //由值创建流
        Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);
        //你可以使用empty得到一个空流，如下所示：
        Stream<String> emptyStream = Stream.empty();

        //由数组创建流
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();

        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);


    }

    public static List<Person> getPersonList(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1L,"张三","zhangsan",16,"java",8000.00));
        personList.add(new Person(2L,"李四","lisi",18,"c++",8000.00));
        personList.add(new Person(3L,"王五","wangwu",20,".net",5000.00));
        personList.add(new Person(4L,"赵六","zhaoliu",12,"python",3000.00));
        return personList;
    }

    public static List<Dish> getDish(){
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );
        return menu;
    };


}
