package main.java.com.introduction.test;

public class OverLode {
    public OverLode(){
        System.out.println("constructor");
    }

    void someMethod(int i){
        System.out.println("int invoke");
    }

    void someMethod(Integer i){
        System.out.println("Integer invoke");
    }

    public static void main(String[] args) {
        //OverLode o = new OverLode();
        //o.someMethod(1);
        Customer c = new Customer("justin");
        some(c);
        System.out.println(c.name);

        Customer c1 = new Customer("justin");
        other(c1);
        System.out.println(c1.name);

    }
    static void some(Customer c){
        c.name="jone";
    }
    static void other(Customer c){
        c = new Customer("bill");
    }

    static {
        System.out.println("static block");
    }
     {
        System.out.println("block");
    }
}

class Customer{
    String name;
    Customer(String name){
        this.name = name;
    }
}
