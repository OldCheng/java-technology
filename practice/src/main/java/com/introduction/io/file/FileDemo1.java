package main.java.com.introduction.io.file;

import main.java.com.util.Constants;

import java.io.File;
import java.io.IOException;

/**
 * @Description
 * @Author 程杰
 * @Date 2020/11/5 20:03
 * @Version 1.0
 */
public class FileDemo1 {
    public static void main(String[] args) {
        String prefixPath = Constants.PREFIX_PATH;
        File file = new File(prefixPath+"io_file_test");
        file.mkdir();   //创建新的文件夹
        File f=new File(prefixPath+"test1.txt");
        f.renameTo(new File(prefixPath+"file.txt"));  //为已知的文件重命名
    }
}
