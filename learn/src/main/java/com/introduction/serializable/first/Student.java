package main.java.com.introduction.serializable.first;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 42L;

    /**
     * 用户名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
