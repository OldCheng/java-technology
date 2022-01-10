package main.java.com.introduction.lambda.example;

import com.sun.tools.javac.util.List;

public class EmployeeDemo {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Justin", 25, Gender.FEMALE),
                new Employee("Monica", 39, Gender.MALE),
                new Employee("Irene", 7, Gender.FEMALE)
        );

        int sum = employees.stream()
                .filter(employee -> employee.getGender() == Gender.MALE)
                .mapToInt(Employee::getAge)
                .sum();
        int average = (int)employees.stream()
                .filter(employee -> employee.getGender() == Gender.MALE)
                .mapToInt(Employee::getAge)
                .average()
                .getAsDouble();

        int max = employees.stream()
                .filter(employee -> employee.getGender() == Gender.MALE)
                .mapToInt(Employee::getAge)
                .max()
                .getAsInt();

        List.of(sum, average, max).forEach(System.out::println);

    }
}
