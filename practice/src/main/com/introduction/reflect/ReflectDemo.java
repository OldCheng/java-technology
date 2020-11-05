package main.com.introduction.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Description
 * @Author 程杰
 * @Date 2020/11/5 16:06
 * @Version 1.0
 */
public class ReflectDemo {

    public static void main(String[] args) {
        //第一种方式获取Class对象
        Student stu = new Student();//这一new 产生一个Student对象，一个Class对象。
        Class<? extends Student> clazz1 = stu.getClass();
        System.out.println(clazz1.getName());

        //第二种方式获取Class对象
        Class calzz2 = Student.class;
        System.out.println(clazz1 == calzz2);//判断第一种方式获取的Class对象和第二种方式获取的是否是同一个

        //第三种方式获取Class对象
        try {
            Class clazz3 = Class.forName("main.com.introduction.reflect.Student");//注意此字符串必须是真实路径，就是带包名的类路径，包名.类名
            System.out.println(clazz3 == calzz2);//判断三种方式是否获取的是同一个Class对象
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //-----------------------------------------------------------
        System.out.println("-----------------------------------------------");
        try {
            Class clazz4 = Class.forName("main.com.introduction.reflect.Student");
            Constructor constructor = clazz4.getConstructor(String.class);
            Object hello_reflect = constructor.newInstance("hello reflect");

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
