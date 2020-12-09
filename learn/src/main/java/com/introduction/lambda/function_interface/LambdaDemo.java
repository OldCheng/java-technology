package main.java.com.introduction.lambda.function_interface;

import main.java.com.introduction.entity.Student;

import javax.sound.midi.Soundbank;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author 程杰
 * @Date 2020/12/9 19:41
 * @Version 1.0
 */
public class LambdaDemo {

    public static void main(String[] args) {

        //在没有lambda表达式之前，如果我们想使用某个接口的一个方法，
        //例如Consumer<T>消费型接口的accept(T)方法，通常做法如下
        //①创建Consumer接口的匿名对象，
        //或者写个类实现这个接口的方法，然后用该类的对象调用accept

        //消费型接口
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String str) {
                System.out.println("接口类型："+str);
            }
        };
        consumer.accept("消费型接口");
        //现在有了lambda表达式，可以进行优雅的简化
        Consumer<String> consumerLambda = str -> System.out.println("lambda 接口类型："+str);
        consumerLambda.accept("消费型接口");
        //现在要说的是lambda表达式的另一种形式，不同于上面的使用箭头操作符的形式
        //这种形式同样能达到相同效果
        //注意Consumer接口的accept方法接受一个参数没有返回值
        //同样的System.out也就是PrintStream的println此刻用的也是一个参数无返回值的方法（虽然方法重载）
        Consumer<String> consumerLambda1 = System.out::println;
        System.out.println("----------------------");
        consumerLambda1.accept("怎么能少的了我呢");


        System.out.println("---------------------------------------------------------------");

        Student student = new Student(123L,"张三","ZhangSan");
        //供给型接口
        Supplier supplier = new Supplier() {
            @Override
            public Object get() {
                return student.getName();
            }
        };
        System.out.println(supplier.get());
        Supplier<String> lambdaSupplier = () -> student.getName();
        Supplier<String> lambdaSupplier1 = student::getName;
        System.out.println(lambdaSupplier.get());
        System.out.println(lambdaSupplier1.get());

        System.out.println("---------------------------------------------------------------------");

        //类名 :: 静态方法名
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        System.out.println(comparator.compare(20, 30));
        System.out.println("====================================================");
        Comparator<Integer> comparator1 = Integer::compare;
        System.out.println(comparator1.compare(20, 30));

        System.out.println("-------------------------------------------------------");

        //函数型接口
        Function<Student, String> function = new Function<Student, String>() {
            @Override
            public String apply(Student stu) {
                return stu.getEngName();
            }
        };
        System.out.println(function.apply(student));

        Function<Student, String> lambdaFunction = stu -> stu.getEngName();
        Function<Student, String> lambdaFunction1 = Student::getEngName;
        System.out.println(lambdaFunction.apply(student));
        System.out.println(lambdaFunction1.apply(student));

        System.out.println("----------------------------------------------------");
        //断言型接口
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String str) {
                return "flag".equals(str);
            }
        };
        System.out.println(predicate.test("flag"));

        Predicate<String> lambdaPredicate = str -> "flag".equals(str);
        System.out.println(lambdaPredicate.test("flag"));
        Predicate<String> lambdaPredicate1 = "flag"::equals;
        System.out.println(lambdaPredicate1.test("flag"));

    }

}
