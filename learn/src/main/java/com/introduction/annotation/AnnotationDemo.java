package main.java.com.introduction.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author 程杰
 * @Date 2020/11/16 11:13
 * @Version 1.0
 */
public class AnnotationDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("main.java.com.introduction.annotation.UseAnnotation");
        Method[] method = clazz.getMethods();
        /**判断Worker类上是否有TypeAnnotation注解*/
        boolean flag = clazz.isAnnotationPresent(TypeAnnotation.class);
        /**获取Worker类上是TypeAnnotation注解值*/
        if (flag) {
            TypeAnnotation typeAnno = (TypeAnnotation) clazz.getAnnotation(TypeAnnotation.class);
            System.out.println("@TypeAnnotation值:" + typeAnno.value());
        }

        /**方法上注解*/
        List<Method> list = new ArrayList<Method>();
        for (int i = 0; i < method.length; i++) {
            list.add(method[i]);
        }

        for (Method m : list) {
            MethodAnnotation methodAnno = m.getAnnotation(MethodAnnotation.class);
            if (methodAnno == null) {
                continue;
            }
            System.out.println( "方法名称:" + m.getName());
            System.out.println("方法上注解name = " + methodAnno.name());
            System.out.println("方法上注解url = " + methodAnno.url());
            System.out.println("--------------------------------------------------");
        }
        /**属性上注解*/
        List<Field> fieldList = new ArrayList<Field>();
        for (Field field : clazz.getDeclaredFields()) {// 访问所有字段
            FiledAnnotation filedAno = field.getAnnotation(FiledAnnotation.class);
            System.out.println("----------"+field);
            System.out.println( "属性名称:" + field.getName());
            System.out.println("属性注解值FiledAnnotation = " + filedAno.value());
        }

        //java.lang.Runtime.availableProcessors() 方法返回到Java虚拟机的可用的处理器数量。
        // 此值可能会改变在一个特定的虚拟机调用。应用程序可用处理器的数量是敏感的，因此偶尔查询该属性，
        // 并适当地调整自己的资源使用情况.
        System.out.println("num:==="+Runtime.getRuntime().availableProcessors());

    }
}
