package main.java.com.introduction.coretechnology.io.test;

import main.java.com.introduction.coretechnology.io.entity.Employee;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class TextFileTest {

    public static void main(String[] args) throws IOException {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("zhang san", 1111, 1991, 1, 1);
        staff[1] = new Employee("li si", 2222, 1992, 2, 2);
        staff[2] = new Employee("wang wu", 3333, 1993, 3, 3);

        try (PrintWriter out = new PrintWriter("file/employee.txt", "utf-8")) {
            writeData(staff,out);
        }

        try(Scanner in = new Scanner(new FileInputStream("file/employee.txt"))){
            Employee[] newStaff = readData(in);
            for (Employee employee : newStaff) {
                System.out.println(employee);
            }
        }

    }

    private static void writeData(Employee[] employee, PrintWriter out) {
        out.println(employee.length);
        for (Employee e : employee) {
            writeEmployee(out,e);
        }
    }

    private static Employee[] readData(Scanner in) {
        int n = in.nextInt();
        in.nextLine();
        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            employees[i] = readEmployee(in);
        }
        return employees;
    }

    private static void writeEmployee(PrintWriter out, Employee e){
        out.println(e.getName()+ "|" + e.getSalary() + "|" + e.getHireDay());
        out.flush();
    }

    public static Employee readEmployee(Scanner in) {
        String line = in.nextLine();
        String[] token = line.split("\\|");
        String name = token[0];
        double salary = Double.parseDouble(token[1]);
        LocalDate hireDate = LocalDate.parse(token[2]);
        int year = hireDate.getYear();
        int month = hireDate.getMonthValue();
        int day = hireDate.getDayOfMonth();
        return new Employee(name, salary, year, month, day);
    }
}
