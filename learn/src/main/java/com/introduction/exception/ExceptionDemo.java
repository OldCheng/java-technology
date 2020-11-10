package main.java.com.introduction.exception;

/**
 * @Description
 * -------------Java 的 java.lang 中定义的未检查异常子类
 * ArithmeticException    算术错误，如被0除
 * ArrayIndexOutOfBoundsException	数组下标出界
 * ArrayStoreException	数组元素赋值类型不兼容
 * ClassCastException	非法强制转换类型
 * IllegalArgumentException	调用方法的参数非法
 * IllegalMonitorStateException	非法监控操作，如等待一个未锁定线程
 * IllegalStateException	环境或应用状态不正确
 * IllegalThreadStateException	请求操作与当前线程状态不兼容
 * IndexOutOfBoundsException	某些类型索引越界
 * NullPointerException	非法使用空引用
 * NumberFormatException	字符串到数字格式非法转换
 * SecurityException	试图违反安全性
 * StringIndexOutOfBounds	试图在字符串边界之外索引
 * UnsupportedOperationException	遇到不支持的操作
 *
 * ---------java.lang 中定义的检查异常
 * ClassNotFoundException	找不到类
 * CloneNotSupportedException	试图克隆一个不能实现Cloneable接口的对象
 * IllegalAccessException	对一个类的访问被拒绝
 * InstantiationException	试图创建一个抽象类或者抽象接口的对象
 * InterruptedException	一个线程被另一个线程中断
 * NoSuchFieldException	请求的字段不存在
 * NoSuchMethodException	请求的方法不存在
 *
 *
 * @Author 程杰
 * @Date 2020/11/6 15:58
 * @Version 1.0
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        int d = 0;
        int a = 42 / d;
    }
}
