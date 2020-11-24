package main.java.com.introduction.annotation;

/**
 * @Description
 * @Author 程杰
 * @Date 2020/11/16 11:14
 * @Version 1.0
 */
@TypeAnnotation(value = "doUseAnnotation")
public class UseAnnotation {
    @FiledAnnotation(value = "CSDN博客")
    private String myfield = "";

    @MethodAnnotation()
    public String getDefaultInfo() {
        return "do the getDefaultInfo method";
    }

    @MethodAnnotation(name = "百度", url = "www.baidu.com")
    public String getDefineInfo() {
        return "do the getDefineInfo method";
    }
}
