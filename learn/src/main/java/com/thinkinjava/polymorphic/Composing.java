package main.java.com.thinkinjava.polymorphic;

/**
 * @Author 程杰
 * @Date 2021/1/14 14:25
 * @Version 1.0
 */
public class Composing {

    private Shared shared;

    private static long counter = 0;

    private final long id = counter++;

    public Composing (Shared shared){
        System.out.println("Composing    " + this);
        this.shared = shared;
        this.shared.addRef();
    }

    protected void dispose(){
        System.out.println("dispose    " + this);
        shared.dispose();
    }

    @Override
    public String toString() {
        return "Composing       "+ id;
    }
}
