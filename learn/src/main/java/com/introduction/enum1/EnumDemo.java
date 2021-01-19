package main.java.com.introduction.enum1;

/**
 * @Author 程杰
 * @Date 2021/1/12 18:16
 * @Version 1.0
 */
public class EnumDemo {
    public static void main(String[] args) {
        SimpleEnum simpleEnum = SimpleEnum.FLAMING;
        System.out.println(simpleEnum);

        System.out.println(SimpleEnum.values());
    }
}
