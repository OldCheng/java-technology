package main.java.com.introduction.entity;

/**
 * @Description
 * @Author 程杰
 * @Date 2020/11/12 17:11
 * @Version 1.0
 */
public class Student {

    private Long id;

    private String name;

    private String engName;

    private int sex;

    private String work;

    private Double salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Student() {
    }

    public Student(Long id, String name, String engName) {
        this.id = id;
        this.name = name;
        this.engName = engName;
    }

    public Student(Long id, String name, String engName, int sex, String work, Double salary) {
        this.id = id;
        this.name = name;
        this.engName = engName;
        this.sex = sex;
        this.work = work;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", engName='" + engName + '\'' +
                ", sex=" + sex +
                ", work='" + work + '\'' +
                ", salary=" + salary +
                '}';
    }

}
