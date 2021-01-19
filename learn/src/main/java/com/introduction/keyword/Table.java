package main.java.com.introduction.keyword;

/**
 * @Author 程杰
 * @Date 2021/1/12 14:25
 * @Version 1.0
 */
public class Table {

    static Bowl bowl = new Bowl(1);
    Table(){
        System.out.println("Table()");
        bowl2.f1(1);
    }

    void f2(int market){
        System.out.println("f2(" + market +")");
    }


    static Bowl bowl2 = new Bowl(2);
}
