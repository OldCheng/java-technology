package main.java.com.introduction.entity;

/**
 * @Author 程杰
 * @Date 2020/12/21 14:55
 * @Version 1.0
 */
public class LeMonde implements Observer {
    @Override
    public void notify(String tweet) {
        if(tweet != null && tweet.contains("wine")){
            System.out.println("Today cheese, wine and news! " + tweet);
        }
    }
}
