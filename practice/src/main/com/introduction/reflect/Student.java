package main.com.introduction.reflect;

/**
 * @Description
 * @Author 程杰
 * @Date 2020/11/5 16:02
 * @Version 1.0
 */
public class Student {

    public String name;

    protected  int age;

    String sex;

    private String body;

    public String hello;


    public Student() {
        System.out.println("----公共-----无参数构造方法");
    }

    public Student(String hello) {
        System.out.println("----公共-----"+hello);
        this.hello = hello;
    }

    protected Student(int age){
        System.out.println("----受保护修饰符-----"+age);
    };

    Student(String name, int age){
        System.out.println("----默认修饰符-----"+"姓名："+name+"年龄："+age);
    };

    private Student(String name, int age, String sex){
        System.out.println("----私有修饰符-----"+"姓名："+name+"年龄："+age+"性别："+sex);
    };

}
