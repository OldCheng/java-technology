package main.java.com.introduction.io.stream.writer;

import main.java.com.util.Constants;

import java.io.*;

/**
 * @Description
 * OutputStreamWriter：是Writer的子类，将输出的字符流转换为字节流。即：将一个字节流的输出对象变为字节流的
 *
 * @Author 程杰
 * @Date 2020/11/6 13:57
 * @Version 1.0
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) throws IOException {
        String prefixPath = Constants.PREFIX_PATH;
        // 第1步、使用File类找到一个文件
        File file = new File(prefixPath + "outputStreamWriter.txt") ;  // 声明File对象
        Writer writer=null;     //字符输出流
        writer=new OutputStreamWriter(new FileOutputStream(file));  //字节流变为字符流
        String str="hello world!!!!";
        writer.write(str);  //使用字符流输出
        writer.close();
    }
}
