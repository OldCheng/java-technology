package main.java.com.introduction.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {
    public static void main(String[] args) {
        Path path = Paths.get("/myproject/java-technology");
        //Path path = Paths.get(System.getProperty("user.home"),"myproject","java-technology");

        System.out.println(path);
        System.out.println(path.getFileName());
        System.out.println(path.getRoot());
        System.out.println(path.getParent());
        System.out.println(path.getNameCount());
        System.out.println(System.getProperty("user.home"));

    }
}
