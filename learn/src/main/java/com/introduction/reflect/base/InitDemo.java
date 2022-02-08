package main.java.com.introduction.reflect.base;

public class InitDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        // 默认力加载.class文件时会执行类中定义的 static 区块。
        // 可以使用 forName() 第二个版本，将’ initialize 设定为 false，
        // 这样加载.class文档时并不会立即执行 static 区块， 而会在建立类实例时才执行 static 区块
        Class clz = Class.forName("main.java.com.introduction.reflect.base.InitClass",
                false, InitDemo.class.getClassLoader());
        System.out.println("已载入 InitClass.class");
        InitClass c;
        System.out.println("声明 InitClass 参考名称");
        c = new InitClass();
        System.out.println("生成 InitClass 实例");
    }
}
