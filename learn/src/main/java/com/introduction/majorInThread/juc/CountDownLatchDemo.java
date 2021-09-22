package main.java.com.introduction.majorInThread.juc;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    //
    static class PreTaskThread implements Runnable {
        private String task;
        private CountDownLatch countDownLatch;

        public PreTaskThread(String task, CountDownLatch countDownLatch) {

            this.task = task;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                Random random = new Random();
                Thread.sleep(random.nextInt(1000));
                System.out.println(task + " - 任务完成");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        //
        CountDownLatch countDownLatch = new CountDownLatch(3);
        //
        new Thread(() -> {
            try {
                System.out.println("等待数据加载 ...");
                System.out.println(String.format("还有%d个前置任务",countDownLatch.getCount()));
                countDownLatch.await();
                System.out.println("数据加载完成，正式开始游戏");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
//
        new Thread(new PreTaskThread("加载地图数据",countDownLatch)).start();
        new Thread(new PreTaskThread("加载任务模型",countDownLatch)).start();
        new Thread(new PreTaskThread("加载背景音乐",countDownLatch)).start();
    }
}
