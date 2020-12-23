package main.java.com.introduction.entity;

/**
 * 好几家报纸机构，比如《纽约时报》《卫报》以及《世
 * 界报》都订阅了新闻，他们希望当接收的新闻中包含他们感兴趣的关键字时，能得到特别通知。
 * 首先，你需要一个观察者接口，它将不同的观察者聚合在一起。它仅有一个名为notify的
 * 方法，一旦接收到一条新的新闻，该方法就会被调用：
 *
 * @Author 程杰
 * @Date 2020/12/21 14:53
 * @Version 1.0
 */
public interface Observer {
    void notify(String tweet);
}
