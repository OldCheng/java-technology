package main.java.com.thinkinjava.genericity;

import java.util.*;

/**
 * @Author 程杰
 * @Date 2021/1/19 11:19
 * @Version 1.0
 */
public class New {

    public static <K, V> Map<K, V> map(){
        return new HashMap<K, V>();
    }

    public static <T> List<T> list(){
        return new ArrayList<T>();
    }

    public static <T>LinkedList<T> linkedList(){
        return new LinkedList<T>();
    }

    public static <T> Set<T> set(){
        return new HashSet<T>();
    }

    public static <T> Queue<T> queue(){
        return new LinkedList<T>();
    }
}
