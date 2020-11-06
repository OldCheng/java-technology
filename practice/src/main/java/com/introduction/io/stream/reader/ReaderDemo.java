package main.java.com.introduction.io.stream.reader;

import main.java.com.util.Constants;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @Description
 * 方法或常量   描述
 * public abstract void close() throws IOException 关闭输出流
 * public int read() throws IOException    读取单个字符
 * public int read(char[] cbuf) throws IOException 将内容读到字符串数组中，返回读入的长度
 *
 *
 * @Author 程杰
 * @Date 2020/11/6 11:41
 * @Version 1.0
 */
public class ReaderDemo {
    public static void main(String[] args) throws IOException {
        String prefixPath = Constants.PREFIX_PATH;
        // 第1步、使用File类找到一个文件
        File file = new File(prefixPath + "writer.txt") ;  // 声明File对象
        // 第2步、通过子类实例化父类对象
        Reader input = null ;   // 准备好一个输入的对象
        input = new FileReader(file)  ;    // 通过对象多态性，进行实例化
        // 第3步、进行读操作
        char chars[] = new char[1024] ;     // 所有的内容都读到此数组之中
        int len = input.read(chars) ;       // 读取内容
        // 第4步、关闭输出流
        input.close() ;                     // 关闭输出流
        System.out.println("内容为：" + new String(chars,0,len)) ;  // 把字符数组变为字符串输出
    }
}
