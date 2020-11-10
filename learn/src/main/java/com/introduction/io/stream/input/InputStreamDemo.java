package main.java.com.introduction.io.stream.input;

import main.java.com.util.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description
 * InputStream类的常用方法：
 * 方法  描述
 * public int available() throws IOException   可以取得输入文件的大小
 * public void close() throws IOException  关闭输入流
 * public abstract int read() throws IOException   读取内容，以数字的方式读取
 * public int read(byte[] b) throws IOException    将内容读到byte数组之中，同时返回个数
 *
 * @Author 程杰
 * @Date 2020/11/5 21:00
 * @Version 1.0
 */
public class InputStreamDemo {
    public static void main(String[] args) throws IOException {
        String prefixPath = Constants.PREFIX_PATH;
        // 第1步、使用File类找到一个文件
        File file = new File(prefixPath + "output.txt") ;  // 声明File对象
        // 第2步、通过子类实例化父类对象
        InputStream input = null ;  // 准备好一个输入的对象
        input = new FileInputStream(file)  ;   // 通过对象多态性，进行实例化
        // 第3步、进行读操作
        byte bytes[] = new byte[1024] ;     // 所有的内容都读到此数组之中
        input.read(bytes) ;     // 读取内容
        // 第4步、关闭输出流
        input.close() ;                     // 关闭输出流
        System.out.println("内容为：" + new String(bytes)) ;    // 把byte数组变为字符串输出
    }
}
