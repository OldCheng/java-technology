package main.java.com.test.lambda;

import main.java.com.testtest.A;

import java.util.Collection;

public class Asd implements Cloneable{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Asd asd = new Asd();
        asd.setName("aaaa");
        Asd asd1 = (Asd) asd.clone();
        System.out.println(asd);
        System.out.println(asd1);
    }

    @Override
    public String toString() {
        return super.toString()+"----------" +"Asd{" +
                "name='" + name + '\'' +
                '}';
    }
}
