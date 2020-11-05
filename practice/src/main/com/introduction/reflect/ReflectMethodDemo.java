package main.com.introduction.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description
 * @Author 程杰
 * @Date 2020/11/5 17:11
 * @Version 1.0
 */
/*
 * 获取成员方法并调用：
 *
 * 1.批量的：
 * 		public Method[] getMethods():获取所有"公有方法"；（包含了父类的方法也包含Object类）
 * 		public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的)
 * 2.获取单个的：
 * 		public Method getMethod(String name,Class<?>... parameterTypes):
 * 					参数：
 * 						name : 方法名；
 * 						Class ... : 形参的Class类型对象
 * 		public Method getDeclaredMethod(String name,Class<?>... parameterTypes)
 *
 * 	 调用方法：
 * 		Method --> public Object invoke(Object obj,Object... args):
 * 					参数说明：
 * 					obj : 要调用方法的对象；
 * 					args:调用方式时所传递的实参；
 */
public class ReflectMethodDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //1.获取Class对象
        Class clazz = Class.forName("main.com.introduction.reflect.Student");
        //2.获取所有公有方法
        System.out.println("---------------获取所有的”公有“方法-------------------");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("---------------获取所有的方法，包括私有的-------------------");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        System.out.println("---------------获取公有的show1()方法-------------------");
        Method study = clazz.getMethod("study", String.class);
        System.out.println(study);
        //实例化一个Student对象
        Object obj = clazz.getConstructor().newInstance();
        study.invoke(obj, "study学习");

        System.out.println("---------------获取私有的show4()方法------------------");
        Method video = clazz.getDeclaredMethod("video", String.class);
        System.out.println(video);
        video.setAccessible(true);//解除私有限定
        Object result = video.invoke(obj, "看电影");//需要两个参数，一个是要调用的对象（获取有反射），一个是实参
        System.out.println("返回值：" + result);

    }
}
