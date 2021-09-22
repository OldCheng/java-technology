package main.java.com.introduction.majorInThread.threadState;

public class Blocked {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            } }, "a");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            } }, "b");
        a.start();
        //a.join();//阻塞main线程，一直到阿线程执行完（成为Thread.State.TERMINATED）
        b.start();
        System.out.println(a.getName() + ":" + a.getState()); //
        System.out.println(b.getName() + ":" + b.getState()); //

    }

    //
    private static synchronized void testMethod() {
        try {
            Thread.sleep(2000L);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } }
}
