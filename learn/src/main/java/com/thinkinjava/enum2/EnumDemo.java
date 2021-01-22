package main.java.com.thinkinjava.enum2;

/**
 * @Author 程杰
 * @Date 2021/1/19 17:34
 * @Version 1.0
 */
public enum  EnumDemo {

    WEST("WEST-----------"),
    NORTH("NORTH----------"),
    EAST("EAST----------"),
    SOUTH("SOUTH---------");

    private String desc;

    EnumDemo(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public static void main(String[] args) {
        for (EnumDemo en : EnumDemo.values()) {
            System.out.println(en+"          "+en.getDesc());
        }
    }
}
