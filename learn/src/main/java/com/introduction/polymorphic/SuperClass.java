package main.java.com.introduction.polymorphic;

/**
 * @Description
 * @Author 程杰
 * @Date 2020/11/10 14:52
 * @Version 1.0
 */
public class SuperClass {

    public String name;

    {
        System.out.println("------sup(父类)-------代码块----------");
    }

    static {
        System.out.println("------sup(父类)-----静态--代码块----------");
    }

    public SuperClass() {
        System.out.println("------sup(父类)-------构造器Constructor----------");
    }

    public void function(){
        System.out.println("-----------父类function-----------");
    }


    private void pr(){
        System.out.println("父 pr()");
    }
}
