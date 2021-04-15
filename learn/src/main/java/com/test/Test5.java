package main.java.com.test;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Description
 * @Author 程杰
 * @Date 2021/4/7 15:40
 * @Version 1.0
 */
public class Test5 {

    public static void main(String[] args) throws InterruptedException {
//        final int totalThread = 10;
//        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        for (int i = 0; i < totalThread; i++) {
//            executorService.execute(() -> {
//                System.out.print("run..");
//                countDownLatch.countDown();
//            });
//        }
//        countDownLatch.await();
//        System.out.println("end");
//        executorService.shutdown();
        semaphore();
    }

    static void semaphore(){
        final int clientCount = 3;
        final int totalRequestCount = 10;
        Semaphore semaphore = new Semaphore(clientCount);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalRequestCount; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    System.out.print(semaphore.availablePermits() + " ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }
        executorService.shutdown();
    }

}
