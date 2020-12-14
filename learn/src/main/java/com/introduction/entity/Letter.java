package main.java.com.introduction.entity;

/**
 * @Author 程杰
 * @Date 2020/12/14 15:59
 * @Version 1.0
 */
public class Letter{
    public static String addHeader(String text){
        return "From Raoul, Mario and Alan: " + text;
    }
    public static String addFooter(String text){
        return text + " Kind regards";
    }
    public static String checkSpelling(String text){
        return text.replaceAll("labda", "lambda");
    }
}
