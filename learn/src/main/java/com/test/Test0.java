package main.java.com.test;


/**
 * @Author 程杰
 * @Date 2021/1/28 11:00
 * @Version 1.0
 */
public class Test0 {

    public static void main(String[] args) {
        String map = "java.util.Map.";
        int i = map.lastIndexOf(".");
        System.out.println(i);
        System.out.println(map.substring(map.lastIndexOf(".") + 1));
        System.out.println(map.substring(0, map.lastIndexOf(".")));
        System.out.println(i);

        Double i1 = 100.0;
        Double i2 = 100.0;
        Double i3 = 200.0;
        Double i4 = 200.0;

        System.out.println(i1==i2); //false
        System.out.println(i3==i4); //false

       // Float
//        HashMap
        Long l1 = 100l;
        Long l2 = 100l;
        Long l3 = 200l;
        Long l4 = 200l;

        System.out.println(l1==l2); //false
        System.out.println(l3==l4); //false

    }
}
