package main.java.com.introduction.io;

import java.io.File;
import java.io.IOException;

/**
 * @Description
 * @Author 程杰
 * @Date 2020/11/5 20:03
 * @Version 1.0
 */
public class IoFile {
    public static void main(String[] args) {

        String prefixPath = "practice/src/main/java/com/introduction/io/iofile";

        File file;
        file = new File(prefixPath+"/file.txt");
        System.out.println("file.pathSeparator:---"+file.pathSeparator);   //调用静态变量
        System.out.println("file.separator:"+file.separator);   //调用静态变量
        if(file.exists()){  //判断当前文件是否存在
            file.delete();      //存在就删除
        }
        try{
            file.createNewFile();   //删除后重新创建
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("文件的大小："+file.length()); //输出新创建文件的大小
    }
}
