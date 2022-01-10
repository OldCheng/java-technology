package main.java.com.introduction.lambda.example;

import com.sun.tools.javac.util.List;

public class EmployeeDemo2 {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Justin", 25, Gender.FEMALE),
                new Employee("Monica", 39, Gender.MALE),
                new Employee("Irene", 7, Gender.FEMALE)
        );

        int sum = employees.stream()
                .filter(employee -> employee.getGender() == Gender.MALE)
                .mapToInt(Employee::getAge)
                .reduce((total, age) -> total +age)
                .getAsInt();

        long males = employees.stream()
                .filter(employee -> employee.getGender() == Gender.MALE)
                .count();

        long average = employees.stream()
                .filter(employee -> employee.getGender() == Gender.MALE)
                .mapToInt(Employee::getAge)
                .reduce((total, age) -> total +age)
                .getAsInt() / males;

        int max = employees.stream()
                .filter(employee -> employee.getGender() == Gender.MALE)
                .mapToInt(Employee::getAge)
                .reduce(0,(currMax, age) -> age > currMax ? age : currMax);

        List.of(sum, average, max).forEach(System.out::println);
        
    }
}
