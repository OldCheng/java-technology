package main.java.com.introduction.keyword;

/**
 * @Author 程杰
 * @Date 2021/1/12 14:30
 * @Version 1.0
 */
public class Cupboard {

    Bowl bowl3 = new Bowl(3);

    static Bowl bowl4 = new Bowl(4);

    Cupboard (){
        System.out.println("Cupboard");
        bowl4.f1(2);
    }
    void f3(int market){
        System.out.println("f3(" + market +")");
    }

    static Bowl bowl5 = new Bowl(5);
}
