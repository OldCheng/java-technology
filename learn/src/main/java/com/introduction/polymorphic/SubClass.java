package main.java.com.introduction.polymorphic;

/**
 * @Description
 * @Author 程杰
 * @Date 2020/11/10 14:52
 * @Version 1.0
 */
public class SubClass extends SuperClass {

    static String sss="面向对象的三大特性：";

    {
        System.out.println("------sub(子类)-------代码块----------");
    }

    static {
        System.out.println("------sub(子类)-----静态--代码块----------");
    }

    public SubClass() {

        System.out.println("------sub(子类)-------构造器Constructor----------");
    }

    @Override
    public void function() {
        System.out.println("-----------子类function-----------");
    }

    public void testVoid(){
        System.out.println("-----------子类testVoid-----------");
    }

    public void  pr(){
        System.out.println("子 pr()");
    }
}
