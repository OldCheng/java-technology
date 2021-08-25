package main.java.com.introduction.serializable.third;

import java.io.*;

public class ExternalizableMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serializable();
        deserializable();
    }

    private static void serializable() throws IOException {
        Person person = new Person("张三", 15);
        System.out.println(person.toString());
        System.out.println("=================开始序列化================");
        FileOutputStream boas = new FileOutputStream("person.log");
        ObjectOutputStream oos = new ObjectOutputStream(boas);
        oos.writeObject(person);
        oos.close();
        boas.close();
    }

    private static void deserializable() throws IOException, ClassNotFoundException {
        System.out.println("============反序列化=============");
        ObjectInputStream bis = new ObjectInputStream(new FileInputStream("person.log"));
        Person person = (Person)bis.readObject();
        System.out.println(person.toString());
    }

    /**
     * 对象的序列化，在实际的开发过程中，使用的非常频繁，尤其是微服务开发，
     * 如果你用的是SpringBoot + Dubbo组合的框架，那么在通过rpc调用的时候，如果传输的对象没有实现序列化，会直接报错！
     * 在使用序列化的时候，坑点还不少，尤其是版本号的问题，这个很容易被忽略，
     * 大家在实际开发的时候，强烈推荐自定义版本号，这样可以避免传输的对象属性发生变化的时候，接口反序列化出错的概率！
     */
}
