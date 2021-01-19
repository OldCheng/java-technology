package main.java.com.thinkinjava.polymorphic;

/**
 * @Author 程杰
 * @Date 2021/1/14 14:24
 * @Version 1.0
 */
public class Shared {

    private int refCount = 0;

    private static long counter = 0;

    private final long id = counter++;

    public Shared(){
        System.out.println("Create    "+ this+"=");
    }

    public void addRef(){
        refCount++;
    }

    protected void dispose(){
        if(--refCount == 0){
            System.out.println("Disposing      " + this);
        }
    }

    @Override
    public String toString() {
        return "Shared      "+ id;
    }
}
