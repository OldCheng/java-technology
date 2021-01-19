package main.java.com.thinkinjava;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 程杰
 * @Date 2021/1/18 9:52
 * @Version 1.0
 */
public class Demo {

    @Override
    public String toString() {
        return "============"+ super.toString();
    }

    public static void main(String[] args) {

//        List<Demo> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add(new Demo());
//        }
//        System.out.println(list);
        System.out.println(new Demo());
    }
}
