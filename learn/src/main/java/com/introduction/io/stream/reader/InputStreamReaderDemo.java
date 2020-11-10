package main.java.com.introduction.io.stream.reader;

import main.java.com.util.Constants;

import java.io.*;

/**
 * @Description
 * InputStreamReader：是Reader的子类，将输入的字节流变为字符流，即：将一个字节流的输入对象变为字符流的输入对象。
 *
 * @Author 程杰
 * @Date 2020/11/6 13:57
 * @Version 1.0
 */
public class InputStreamReaderDemo {
    public static void main(String[] args) throws IOException {
        String prefixPath = Constants.PREFIX_PATH;
        // 第1步、使用File类找到一个文件
        File file = new File(prefixPath + "outputStreamWriter.txt") ;  // 声明File对象
        Reader reader = null ;
        reader = new InputStreamReader(new FileInputStream(file)) ;    // 将字节流变为字符流
        char chars[] = new char[1024] ;
        int len = reader.read(chars) ;  // 读取
        reader.close() ;    // 关闭
        System.out.println(new String(chars,0,len)) ;
    }

    /**
     * @Description
     * 对于FileWriter和FileReader的说明：
     * 从JDK文档中可知FileOutputStream是OutputStream的直接子类，FileInputStream也是InputStream的直接子类，
     * 但是在字符流文件的两个操作类却有一些特殊，FileWriter并不是Writer的子类，而是OutputStream的子类，
     * 而FileReader也不是Reader的直接子类，是InputStreamReader的子类。
     *
     */
}
