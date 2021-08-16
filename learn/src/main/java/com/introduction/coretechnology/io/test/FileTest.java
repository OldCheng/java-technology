package main.java.com.introduction.coretechnology.io.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileTest {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("file","txt","test.txt");
        Path path1 = Paths.get("file","txt","str.txt");
//        byte[] bytes = Files.readAllBytes(path);
//        String content = new String(bytes, StandardCharsets.UTF_8);
//        System.out.println(content);
//        List<String> list = Files.readAllLines(path);
//        Files.write(path1, content.getBytes(StandardCharsets.UTF_8));
//        Files.write(path1, list);
//        Files.write(path1, list, StandardOpenOption.APPEND);

        InputStream in = Files.newInputStream(path);
        int read = in.read();
        OutputStream out = Files.newOutputStream(path1);
        out.write(read);



    }
}
