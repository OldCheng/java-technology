package main.java.com.introduction.test;

import java.util.ArrayList;
import java.util.Arrays;
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


        String s1 ="qwer";
        String s2 ="qw"+new String("er");
        String s3 ="qw"+"er";
        System.out.println(s1==s3);
        System.out.println(s1==s2);

        String str = ";t;;";

        String [] s = str.split(";");
        String [] strarr = {"123123",""};

        Long[] skuIds = Arrays.stream(strarr).map(Long::valueOf).toArray(Long[]::new);


    }


    public boolean asd(){
        System.out.println("diaoyongl");
        return false;
    }

}
