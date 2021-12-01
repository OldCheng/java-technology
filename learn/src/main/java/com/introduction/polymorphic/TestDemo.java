package main.java.com.introduction.polymorphic;


/**
 * @Description
 * @Author 程杰
 * @Date 2020/11/10 14:55
 * @Version 1.0
 */
public class TestDemo {
    public static void main(String[] args) {
        SuperClass superClass = new SuperClass();
        SubClass subClass = new SubClass();
        SubClass2 subClass2 = new SubClass2();
        System.out.println(subClass instanceof SuperClass);
        System.out.println(subClass instanceof SubClass);
        System.out.println(superClass instanceof SubClass);
        System.out.println(subClass2 instanceof SuperClass);
        System.out.println(subClass2 instanceof SuperClass);
//        superClass.function();
//        //superClass.testVoid();
//        ((SubClass) superClass).pr();
//        SubClass subClass = (SubClass) superClass;
//        subClass.testVoid();
    }

}
