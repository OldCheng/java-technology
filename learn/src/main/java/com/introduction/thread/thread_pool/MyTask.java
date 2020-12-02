package main.java.com.introduction.thread.thread_pool;

/**
 * @Description
 * @Author 程杰
 * @Date 2020/12/2 14:41
 * @Version 1.0
 */
public class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }

    @Override
    public void run() {
        System.out.println("正在执行task "+taskNum);
        try {
            Thread.currentThread().sleep(4000);
            System.out.println("--------------------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task "+taskNum+"执行完毕");
    }
}
