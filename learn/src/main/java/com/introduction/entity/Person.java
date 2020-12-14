package main.java.com.introduction.entity;

/**
 * @Author 程杰
 * @Date 2020/12/14 11:46
 * @Version 1.0
 */
public class Person {

    private Long id;

    private String name;

    private String engName;

    private Integer age;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public Person(Long id, String name, String engName, Integer age, String work, Double salary) {
        this.id = id;
        this.name = name;
        this.engName = engName;
        this.age = age;
        this.work = work;
        this.salary = salary;
    }
}
