package main.java.com.thinkinjava.polymorphic;

/**
 * @Author 程杰
 * @Date 2021/1/14 14:26
 * @Version 1.0
 */
public class ReferenceCounting {
    public static void main(String[] args) {

        Shared shared = new Shared();

        Composing [] composings = {new Composing(shared)
                ,new Composing(shared)
                ,new Composing(shared)
                ,new Composing(shared)
                ,new Composing(shared)};
        for (Composing composing : composings) {
            composing.dispose();
        }


    }
}
