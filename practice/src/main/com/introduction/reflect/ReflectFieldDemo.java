package main.com.introduction.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @Description
 * @Author 程杰
 * @Date 2020/11/5 16:47
 * @Version 1.0
 */
/*
 * 获取成员变量并调用：
 *
 * 1.批量的
 * 		1).Field[] getFields():获取所有的"公有字段"
 * 		2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；
 * 2.获取单个的：
 * 		1).public Field getField(String fieldName):获取某个"公有的"字段；
 * 		2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)
 *
 * 	 设置字段的值：
 * 		Field --> public void set(Object obj,Object value):
 * 					参数说明：
 * 					1.obj:要设置的字段所在的对象；
 * 					2.value:要为字段设置的值；
 */

public class ReflectFieldDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //1.获取Class对象
        Class clazz = Class.forName("main.com.introduction.reflect.Student");
        //2.获取字段
        System.out.println("--------------获取所有公有的字段-----------------------");
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("---------------获取所有的字段(包括私有、受保护、默认的)----------------------");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println("---------------获取公有字段----并调用------------------");
        Field field = clazz.getField("name");
        System.out.println(field);
        //获取一个对象
        Object obj = clazz.getConstructor().newInstance();//产生Student对象--》Student stu = new Student();
        //为字段设置值
        field.set(obj, "李二狗");//为Student对象中的name属性赋值--》stu.name = "刘德华"
        //验证
        Student stu = (Student)obj;
        System.out.println("验证姓名：" + stu.name);


        System.out.println("-----------------获取私有字段---并调用-------------------------");
        Field filed = clazz.getDeclaredField("body");
        System.out.println(filed);
        filed.setAccessible(true);//暴力反射，解除私有限定
        filed.set(obj, "身体是革命的本钱");
        System.out.println("验证身体健康：" + stu);

    }
}
