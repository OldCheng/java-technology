package main.java.com.test.lambda;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestToMap {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("s");
        System.out.println(a);

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("qwe", 20, new BigDecimal(80), 1));
        studentList.add(new Student("qwe", 22, new BigDecimal(90), 2));
        studentList.add(new Student("asd", 21, new BigDecimal(65.5), 3));
        Map<String, Student> collect = studentList.stream().collect(Collectors.toMap(Student::getStuName, Function.identity(),(key1,key2) -> key2));
        System.out.println(collect);

        Queue<String> q = new PriorityQueue<>();
        q.add("a");
        q.add("b");
        q.add("c");
        q.add("d");

        System.out.println( q.poll());
        System.out.println( q.poll());
        System.out.println( q.poll());
        System.out.println(q.peek());

        //LocalDateTime l = LocalDateTime.now();
        Date d = new Date(1636510347737l);
        System.out.println(d);

    }
}
