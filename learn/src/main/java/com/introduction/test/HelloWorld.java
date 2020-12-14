package main.java.com.introduction.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author 程杰
 * @Date 2020/11/4 19:38
 * @Version 1.0
 */
public class HelloWorld {

    public static int value = 33;

    public static void main(String[] args) {
        System.out.println("hello world--!!!!!");
        List<String> list = new ArrayList<>();
        HelloWorld h = new HelloWorld();

        if(false || h.asd()){
            System.out.println("----------");
        }


    }


    public boolean asd(){
        System.out.println("diaoyongl");
        return false;
    }
}
