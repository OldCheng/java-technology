package main.java.com.introduction.coretechnology.io.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
    public static void main(String[] args) {
        Path path = Paths.get("file");
        Path path1 = Paths.get("txt","txt","test.txt");
        System.out.println("Parent: "+path1.getParent());
        System.out.println("FileName: "+path1.getFileName());
        System.out.println("root: "+path1.getRoot());
        System.out.println(path);
    }
}
