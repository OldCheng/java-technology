package main.java.com.introduction.test;

/**
 * @Author 程杰
 * @Date 2020/12/7 15:15
 * @Version 1.0
 */
public class FinalDemo {

    public static void main(String[] args)  {
        MyClass myClass = new MyClass();
        StringBuffer buffer = new StringBuffer("hello");
        myClass.changeValue(buffer);
        System.out.println(buffer.toString());
    }
}

class MyClass {

    void changeValue(final StringBuffer buffer) {
        buffer.append("world");
    }
}