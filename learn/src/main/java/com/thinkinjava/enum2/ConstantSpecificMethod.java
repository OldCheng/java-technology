package main.java.com.thinkinjava.enum2;

import java.text.DateFormat;
import java.util.Date;

/**
 * @Author 程杰
 * @Date 2021/1/19 17:50
 * @Version 1.0
 */
public enum ConstantSpecificMethod {
    DATE_TIME{
        @Override
        String getInfo(){
            return DateFormat.getDateInstance().format(new Date());
        }
    },

    CLASSPATH{
        @Override
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },

    VERSION{
        @Override
        String getInfo() {
            return System.getProperty("java.version");
        }
    };

    abstract String getInfo();

    public static void main(String[] args) {

        for (ConstantSpecificMethod arg : values()) {
            System.out.println(arg.getInfo());
        }
    }

}
