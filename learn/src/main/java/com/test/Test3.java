package main.java.com.test;

import java.util.Random;
import java.util.Scanner;

/**
 * @Description
 * @Author 程杰
 * @Date 2021/3/30 17:23
 * @Version 1.0
 */
public class Test3 {

    private int robotCoins = 10;
    private int userCoins = 10;

    public static void main(String[] args) {

        Test3 test3 = new Test3();
        test3.rungame();
    }

    public void rungame(){
        Scanner scan = new Scanner(System.in);
        while (true){
            String take = scan.next();
            if("q".equals(take)){
                System.out.println("结束了");
                break;
            }
            guess(take);
            if(robotCoins == 0 || userCoins == 0){
                System.out.println("userCoins="+userCoins+"      robotCoins="+robotCoins);
                System.out.println("结束了");
                break;
            }
        }
    }

    /**
     * 生成2-12随机数
     */
    int getRandomCount(){
        Random rd = new Random(); //创建一个Random类对象实例
        return rd.nextInt(10)+2;
    }

    /**
     * 输赢扣硬币与加硬币
     * @param guess
     */
    void guess(String guess){
        int rd = getRandomCount();
        System.out.println("随机数="+rd);
        if("b".equals(guess)){
            if(rd > 7){
                userCoins++;
                robotCoins--;
            }else if (rd < 7){
                userCoins--;
                robotCoins++;
            }
        }else if("s".equals(guess)){
            if(rd < 7){
                userCoins++;
                robotCoins--;
            }else if (rd > 7){
                userCoins--;
                robotCoins++;
            }
        }
        System.out.println("用户="+userCoins+"机器="+robotCoins);
    }
}
