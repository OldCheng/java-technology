package main.java.com.introduction.entity;

/**
 * @Author 程杰
 * @Date 2020/12/16 20:07
 * @Version 1.0
 */
public class Trader {

    private final String name;
    private final String city;
    public Trader(String n, String c){
        this.name = n;
        this.city = c;
    }
    public String getName(){
        return this.name;
    }
    public String getCity(){
        return this.city;
    }

    @Override
    public String toString(){
        return "Trader:"+this.name + " in " + this.city;
    }
}
