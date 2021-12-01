package main.java.com.test.lambda;

import java.math.BigDecimal;
import java.util.Objects;

public class Student {

    Student(){}

    public Student(String stuName, int age, BigDecimal score, int clazz) {
        this.stuName = stuName;
        this.age = age;
        this.score = score;
        this.clazz = clazz;
    }

    private String stuName;
    private int age;
    private BigDecimal score;
    private int clazz;

    public Student(Student student) {
    }

    public String getStuName() {
        return stuName;
    }
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public BigDecimal getScore() {
        return score;
    }
    public void setScore(BigDecimal score) {
        this.score = score;
    }
    public int getClazz() {
        return clazz;
    }
    public void setClazz(int clazz) {
        this.clazz = clazz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuName='" + stuName + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", clazz=" + clazz +
                '}';
    }
}
