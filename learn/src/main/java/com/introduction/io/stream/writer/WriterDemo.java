package main.java.com.introduction.io.stream.writer;

import main.java.com.util.Constants;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @Description
 * 方法或常量   描述
 * public abstract void close() throws IOException 关闭输出流
 * public void write(String str) throws IOException    将字符串输出
 * public void write(char[] cbuf) throws IOException   将字符数组输出
 * public abstract void flush() throws IOException 强制性清空缓存
 *
 *
 * @Author 程杰
 * @Date 2020/11/6 11:38
 * @Version 1.0
 */
public class WriterDemo {
    public static void main(String[] args) throws IOException {
        String prefixPath = Constants.PREFIX_PATH;
        // 第1步、使用File类找到一个文件
        File file = new File(prefixPath + "writer.txt") ;  // 声明File对象
        // 第2步、通过子类实例化父类对象
        Writer out = null ; // 准备好一个输出的对象
        out = new FileWriter(file)  ;  // 通过对象多态性，进行实例化
        // 第3步、进行写操作
        String str = "Hello World!!!1111" ;     // 准备一个字符串
        out.write(str) ;                        // 将内容输出，保存文件
        //out.flush();
        // 第4步、关闭输出流
        out.close() ;                       // 关闭输出流
    }

    /**
     * @Description
     *字节流在操作的时候本身是不会用到缓冲区(内存)的，是与文件本身直接操作的，而字符流在操作的时候使用到缓冲区的。
     * 通过代码来验证字符流使用到了缓存。
     * 在使用字节流操作中，即使没有关闭，最终也是可以输出的。
     *
     *在字符流中没有关闭(没调用close方法 )则不能写入文件，除非调用flush方法，刷新缓冲区
     *在所有的硬盘保存文件或是进行传输的时候都是以字节的方式进行的。包括图片也是按字节完成，而字符只有在内存中才会形成。
     * 所以在开发中使用字节的操作是较多的。
     *
     */
}
