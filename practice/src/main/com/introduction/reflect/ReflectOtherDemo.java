package main.com.introduction.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @Description
 * @Author 程杰
 * @Date 2020/11/5 17:26
 * @Version 1.0
 */
public class ReflectOtherDemo {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");

        //	strList.add(100);
        //获取ArrayList的Class对象，反向的调用add()方法，添加数据
        Class calzz = list.getClass(); //得到 strList 对象的字节码 对象
        //获取add()方法
        Method add = calzz.getMethod("add", Object.class);
        //调用add()方法
        add.invoke(list, 100);

        //遍历集合
        for(Object obj : list){
            System.out.println(obj);
        }
    }
}
