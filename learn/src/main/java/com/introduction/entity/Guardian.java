package main.java.com.introduction.entity;

/**
 * @Author 程杰
 * @Date 2020/12/21 14:55
 * @Version 1.0
 */
public class Guardian implements Observer {
    @Override
    public void notify(String tweet) {
        if(tweet != null && tweet.contains("queen")){
            System.out.println("Yet another news in London... " + tweet);
        }
    }
}
