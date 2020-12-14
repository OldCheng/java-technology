package main.java.com.java8inaction.lambda;

import main.java.com.introduction.entity.Dish;
import main.java.com.introduction.entity.Letter;
import main.java.com.introduction.entity.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

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

        System.out.println("-----------------------------------------------------");
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
