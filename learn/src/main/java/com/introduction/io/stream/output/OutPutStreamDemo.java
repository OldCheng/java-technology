package main.java.com.introduction.io.stream.output;

import main.java.com.util.Constants;

import java.io.*;

/**
 * @Description
 * 方法  描述
 * public void close() throws IOException  关闭输出流
 * public void flush() throws IOException  刷新缓冲区
 * public void write(byte[] b) throws IOException  将一个byte数组写入数据流
 * public void write(byte[] b,int off,int len)throws IOException   将一个指定范围的byte数组写入数据流
 * public abstract void write(int b) throws IOException    将一个字节数据写入数据流
 *
 * @Author 程杰
 * @Date 2020/11/5 20:49
 * @Version 1.0
 */
public class OutPutStreamDemo {
    public static void main(String[] args) {
        String prefixPath = Constants.PREFIX_PATH;
        //1、使用File类指定一个文件名
        File file=new File(prefixPath + "output.txt");
        //2、创建OutputStream类，并为此实例化对象
        OutputStream out= null;
        try {
            out = new FileOutputStream(file);
            //3、执行写入操作
            String str= "Hello world 11 wwwwww11";
            byte[] bytes = str.getBytes();
            out.write(bytes);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、关闭输入流
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
