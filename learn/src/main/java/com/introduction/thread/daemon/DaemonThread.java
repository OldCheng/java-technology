package main.java.com.introduction.thread.daemon;

import main.java.com.thinkinjava.annotations.Test;

public class DaemonThread {

//    public static void main(String[] args) {
//        Thread t = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    System.out.println(Thread.currentThread().getName() + "running");
//                    Thread.sleep(10_000);
//                    System.out.println(Thread.currentThread().getName() + "done");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        // t.setDaemon(true);
//        t.start();
//        System.out.println("main done");
//    }

    public static void main(String[] args) {
        // t 线程模拟网络长连接
        Thread t = new Thread(() -> {
            // innerThread 线程模拟发送心跳的线程
            Thread  innerThread = new Thread(() -> {
                try {
                    while(true) {
                        System.out.println("发送心跳");
                        Thread.sleep(1_000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            //innerThread.setDaemon(true);
            innerThread.start();
            try {
                Thread.sleep(1_000);// 模拟长连接1秒以后就退出
                System.out.println("T Thread done");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t.start();
    }

}
