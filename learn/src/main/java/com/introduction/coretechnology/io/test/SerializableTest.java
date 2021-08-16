package main.java.com.introduction.coretechnology.io.test;

import main.java.com.introduction.coretechnology.io.entity.Employee;

import java.io.*;

public class SerializableTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("file/employee.txt"));
        Employee zs = new Employee("zhang san", 1111, 1991, 1, 1);
        Employee ls = new Employee("li si", 2222, 1992, 2, 2);
        out.writeObject(zs);
        out.writeObject(ls);

        ObjectInputStream in  = new ObjectInputStream(new FileInputStream("file/employee.txt"));
        Employee e1 = (Employee) in.readObject();
        Employee e2 = (Employee) in.readObject();

    }
}
