package main.java.com.introduction.majorInThread.juc;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    static class PreTaskThread implements Runnable {
        private String task;
        private CyclicBarrier cyclicBarrier;

        public PreTaskThread(String task, CyclicBarrier cyclicBarrier) {
            this.task = task;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            // 假设总共3个关卡
            for (int i = 1; i < 4; i++) {
                try {
                    Random random = new Random();
                    //Thread.sleep(random.nextInt(1000));
                    System.out.println(String.format("关卡%d的任务%s完成", i, task));
                    System.out.println("thread---name::"+Thread.currentThread().getName());
                    cyclicBarrier.await();
                    System.out.println("await--------"+Thread.currentThread().getName());
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                //System.out.println("rest-----thread---name::"+Thread.currentThread().getName());
                cyclicBarrier.reset(); //重置屏障
            }
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("本关卡所有前置任务完成，开始游戏....");
        });

        new Thread(new PreTaskThread("加载地图数据", cyclicBarrier),"ttt1").start();
        new Thread(new PreTaskThread("加载任务模型", cyclicBarrier),"ttt2").start();
        new Thread(new PreTaskThread("加载背景音乐", cyclicBarrier),"ttt3").start();
    }
}
