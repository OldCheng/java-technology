package main.java.com.introduction.thread.thread_pool;

import java.util.concurrent.*;

/**
 * @Description
 * @Author 程杰
 * @Date 2020/12/1 16:44
 * @Version 1.0
 */
public class ThreadPool {
    public static void main(String[] args) {
//        ExecutorService executor = Executors.newFixedThreadPool(5);
//        for (int i = 0; i < 10; i++) {
//            executor.submit(() -> {
//                System.out.println("thread id is: " + Thread.currentThread().getId());
//                try {
//                    Thread.sleep(5000L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));

        for(int i=0;i<15;i++){
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();

    }
}
