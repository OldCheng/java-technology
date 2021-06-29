package main.java.com.introduction.coretechnology.io.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class Test {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(System.getProperty("user.dir"));
        PrintWriter pw = new PrintWriter(new FileOutputStream("file/employee.txt", Boolean.parseBoolean("utf-8")));
        String name ="zhang san";
        String salary = "$89991";
        pw.println(name);
        pw.println("  ");
        pw.println(salary);
        pw.flush();

    }
}
