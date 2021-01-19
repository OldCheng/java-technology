package main.java.com.introduction.test;

import java.util.*;

/**
 * @Author 程杰
 * @Date 2021/1/15 16:09
 * @Version 1.0
 */
public class Test1 {

    public static void main(String[] args) {
        aa();
    }

    static void aa() {
        try {
            throw new NullPointerException("aaaaaaaaaa");
        }catch (Exception e){
            System.out.println(e);
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
