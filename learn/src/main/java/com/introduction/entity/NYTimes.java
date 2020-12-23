package main.java.com.introduction.entity;

/**
 * @Author 程杰
 * @Date 2020/12/21 14:54
 * @Version 1.0
 */
public class NYTimes implements Observer {
    @Override
    public void notify(String tweet) {
        if(tweet != null && tweet.contains("money")){
            System.out.println("Breaking news in NY! " + tweet);
        }
    }
}
