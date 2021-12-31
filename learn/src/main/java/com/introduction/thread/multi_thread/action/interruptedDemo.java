package main.java.com.introduction.thread.multi_thread.action;

public class interruptedDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("我要睡了");
                Thread.sleep(5000);
                System.out.println("干活了....");
            } catch (Exception e) {
                System.out.println("我醒了....");
            }
        });
        thread.start();
        //thread.interrupt();//主线程调用thread 的 interrupt()
    }
}
