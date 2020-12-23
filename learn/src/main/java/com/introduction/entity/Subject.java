package main.java.com.introduction.entity;

/**
 * @Author 程杰
 * @Date 2020/12/21 14:57
 * @Version 1.0
 */
public interface Subject {
    void registerObserver(Observer o);
    void notifyObservers(String tweet);
}
