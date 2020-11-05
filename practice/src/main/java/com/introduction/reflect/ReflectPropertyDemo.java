package main.java.com.introduction.reflect;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Description
 * @Author 程杰
 * @Date 2020/11/5 17:29
 * @Version 1.0
 */
/*
 * 通过反射越过泛型检查
 * 例如：有一个String泛型的集合，怎样能向这个集合中添加一个Integer类型的值？
 */
public class ReflectPropertyDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        Class clazz1 = Class.forName("main.com.introduction.reflect.ReflectPropertyDemo");
//        String filePath = clazz1.getResource("pro.txt").getPath();
//        System.out.println("filePath: "+filePath);
        //通过反射获取Class对象
        Class clazz = Class.forName(getValue("className"));
        //2获取show()方法
        Method m = clazz.getMethod(getValue("methodName"));
        //3.调用show()方法
        m.invoke(clazz.getConstructor().newInstance());

    }

    //此方法接收一个key，在配置文件中获取相应的value
    public static String getValue(String key) throws IOException {
        Properties pro = new Properties();//获取配置文件的对象
        //FileReader in = new FileReader("practice/src/main/com/introduction/reflect/pro.txt");//获取输入流
        FileReader in = new FileReader("D:\\java-technology\\practice\\src\\main\\com\\introduction\\reflect\\pro.txt");//获取输入流
        pro.load(in);//将流加载到配置文件对象中
        in.close();
        return pro.getProperty(key);//返回根据key获取的value值
    }

}
