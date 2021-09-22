package main.java.com.introduction.thread.multi_thread.prctice;

public class Test {
    public static void main(String[] args) {
            Thread testThread = new Thread(() -> { System.out.println("testThread group :" +
                    Thread.currentThread().getThreadGroup().getName()); System.out.println("testThread :" +
                    Thread.currentThread().getName());
            });
            testThread.start();
        System.out.println(" main group :" + Thread.currentThread().getName() );
            System.out.println(" main :" + Thread.currentThread().getName() );
    }
}
