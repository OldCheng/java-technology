package main.java.com.introduction.serializable.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectMainTest {

    public static void main(String[] args) throws Exception {
        serializeObject();
        deserializeObject();
    }

    private static void serializeObject() throws Exception {
        Child child = new Child();
        child.setId("123");
        child.setName("张三");
        System.out.println("id:" +  child.getId() + ",name:" +  child.getName());
        System.out.println("=================开始序列化================");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.log"));
        oos.writeObject(child);
        oos.flush();
        oos.close();
    }

    private static void deserializeObject() throws Exception {
        System.out.println("=================开始反序列化================");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.log"));
        Child child = (Child) ois.readObject();
        ois.close();
        System.out.println("id:" +  child.getId() + ",name:" +  child.getName());
    }

    /**
     * 父类、子类序列化问题
     * 1.父类没有实现序列化，子类实现序列化
     * 结果：结果很明显，父类的属性没有被序列化进去！
     * 2.父类实现序列化，子类不实现序列化
     * 结果：结果很明显，父类的属性被序列化进去！
     * 3.父类实现序列化，子类实现序列化
     * 结果：父类的属性序列化依然成功
     *
     * 总结起来，当父类实现序列化时，子类所有的属性也会全部被序列化；
     * 但是当父类没有实现序列化，子类在序列化时，父类属性并不会被序列化！
     */
}
