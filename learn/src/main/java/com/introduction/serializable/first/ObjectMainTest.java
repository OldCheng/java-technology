package main.java.com.introduction.serializable.first;

import java.io.*;

public class ObjectMainTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //序列化
        serializeObject();
        //反序列化
        deserializeObject();
    }

    private static void serializeObject() throws IOException {
        Student student = new Student("张三", 20);
        System.out.println(student.toString());
        System.out.println("=========开始序列化===========");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.log"));
        oos.writeObject(student);
        oos.flush();
        oos.close();
    }

    private static void deserializeObject() throws IOException, ClassNotFoundException {
        System.out.println("=========开始反序列化===========");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.log"));
        Student student = (Student) ois.readObject();
        ois.close();
        System.out.println(student.toString());
    }

    /**
     * 序列化和反序列化
     * 光看定义上，对于初学者来说，可能很难一下子理解序列化的意义，尤其是面对这种特别学术词语的时候，内心会不由自主的发问：它到底是啥，用来干嘛的？
     * 如果用通俗的方式来理解，你可以用变魔术的方式来理解它，就好比你想把一件铁器从一个地方运往到另一个地方，在出发的时候，通过魔术方式将这个东西融化成一桶铁水，当到达目的地之后，又通过变魔术的方式，将这桶铁水还原成一件铁器。当铁器变成铁水的过程，可以理解为序列化；从铁水变成铁器，可以理解为反序列化。
     * 站在程序世界的角度看，我们都知道计算机之间传递信息的最小单元是字节流，序列化其实就是将一个对象变成所有的计算机都能识别的字节流；反序列化就是将接受到的字节流还原成一个程序能识别的对象。
     *
     * 简单的说，序列化最终的目的是为了对象可以更方面的进行跨平台存储和进行网络传输。
     * 基本上只要是涉及到跨平台存储或者进行网络传输的数据，都需要进行序列化。
     */

    /**
     * 序列化技术的选型，主要可以从以下几个方面进行考虑：
     *
     * 是否支持跨平台：尤其是多种语言混合开发的项目，是否支持跨平台直接决定了系统开发难度
     * 序列化的速度：速度快的方式会为你的系统性能提升不少
     * 序列化出来的大小：数据越小越好，小的数据传输快，也不占带宽，也能整体提升系统的性能
     */

    /**
     * 1、static 属性不能被序列化
     * 实际在序列化的时候，被static修饰的属性字段是不能被序列化进去的，因为静态变量属于类的状态，序列化并不保存静态变量！
     *
     * 2、Transient 属性不会被序列化
     * 被Transient修饰的属性无法被序列化，眼见为实，我们给Student类的name字段加一个transient修饰符。
     */

}
