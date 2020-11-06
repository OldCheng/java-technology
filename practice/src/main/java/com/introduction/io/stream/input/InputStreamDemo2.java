package main.java.com.introduction.io.stream.input;

import main.java.com.util.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description
 * @Author 程杰
 * @Date 2020/11/6 11:18
 * @Version 1.0
 */
public class InputStreamDemo2 {
    public static void main(String[] args) throws IOException {
        String prefixPath = Constants.PREFIX_PATH;
        // 第1步、使用File类找到一个文件
        File file = new File(prefixPath + "output.txt") ;  // 声明File对象
        // 第2步、通过子类实例化父类对象
        InputStream input = null ;  // 准备好一个输入的对象
        input = new FileInputStream(file)  ;   // 通过对象多态性，进行实例化
        // 第3步、进行读操作
        byte bytes[] = new byte[1024] ;     // 数组大小由文件决定
        int len = 0 ;
        int temp = 0 ;          // 接收每一个读取进来的数据
        while((temp=input.read())!=-1){
            // 表示还有内容，文件没有读完
            bytes[len] = (byte)temp ;
            len++ ;
        }
        // 第4步、关闭输出流
        input.close() ;
        // 关闭输出流\
        System.out.println("内容为：" + new String(bytes,0,len)) ;  // 把byte数组变为字符串输出

    }
}
