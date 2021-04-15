package main.java.com.introduction.thread.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Description
 * @Author 程杰
 * @Date 2021/3/28 15:52
 * @Version 1.0
 */
public class JUCDemo {

    public static void main(String[] args) throws InterruptedException {
//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        for (int i = 0; i < 5; i++) {
//            new Thread(() -> {
//                try {
//                    //准备完毕……运动员都阻塞在这，等待号令
//                    countDownLatch.await();
//                    String parter = "【" + Thread.currentThread().getName() + "】";
//                    System.out.println(parter + "开始执行……");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//        }
//
//        Thread.sleep(2000);// 裁判准备发令
        //countDownLatch.countDown();// 发令枪：执行发令

        fuc();
    }

    public static void fuc() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            final int index = i;
            new Thread(() -> {
                try {
                    Thread.sleep(1000 + ThreadLocalRandom.current().nextInt(1000));
                    System.out.println("finish" + index + Thread.currentThread().getName());
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        countDownLatch.await();// 主线程在阻塞，当计数器==0，就唤醒主线程往下执行。
        System.out.println("主线程:在所有任务运行完成后，进行结果汇总");
    }
}
