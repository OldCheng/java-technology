package main.java.com.introduction.lambda;

import main.java.com.introduction.entity.Student;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @Description
 * @Author 程杰
 * @Date 2020/11/12 17:14
 * @Version 1.0
 */
public class TestDemo {
    public static void main(String[] args) {

        Student student1 = new Student(1L,"张三","ZhangSan",1,"java",5000.00);
        System.out.println(student1);
        System.out.println("ssssssssssssssssssssssssssssssssssssssssssssssssssssss");

        List<Student> studentList = getStudentList();

        aaa( cos -> System.out.println("kkkkkkk"));
        System.out.println("------------------------------------");
        aaa(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });

        studentList.stream().filter(student -> student.getSalary() > 5000).forEach(stu ->System.out.println(stu));
        //studentList.stream().map(student -> student.getEngName().toUpperCase()).forEach(stu -> System.out.println(stu));
        //studentList.stream().map(student -> student.getEngName().toUpperCase()).collect(Collectors.toList()).forEach(s -> System.out.println(s));
        studentList.stream().map(Student::getEngName).collect(Collectors.joining(", ", "[", "]"));

//        Collections.sort(studentList, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getSalary().compareTo(o2.getSalary());
//            }
//        });

        System.out.println("---------------------------------------");
//        studentList.sort(new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getSalary().compareTo(o2.getSalary());
//            }
//        });
//        studentList.forEach(student -> System.out.println(student));
        studentList.stream().sorted(Comparator.comparing(Student::getSalary)).forEach(student -> System.out.println(student));

    }

    public static List<Student> getStudentList(){
        Student student1 = new Student(1L,"张三","ZhangSan",1,"java",5000.00);
        Student student2 = new Student(9L,"杜九","DuJiu",2,"c++",4000.00);
        Student student3 = new Student(4L,"李四","LiSi",1,"python",8000.00);
        Student student4 = new Student(7L,"王七","WangQi",2,"php",2000.00);
        Student student5 = new Student(8L,"朱八","ZhuBa",2,"go",6000.00);
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        return studentList;
    }

    public static void aaa(Consumer consumer){
        consumer.accept("asdad");
        System.out.println("sssssssssss");
    }

    public List<Student> getStudentList(int length){
        List<Student> studentList = new ArrayList<>();
        for(int i = 0; i<length; i++){
            Student student = new Student();
        }
        return null;
    }

}
