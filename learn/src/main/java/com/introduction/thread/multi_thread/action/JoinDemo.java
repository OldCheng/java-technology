package main.java.com.introduction.thread.multi_thread.action;

public class JoinDemo {
//    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(() -> {
//            System.out.println("开始执行....");
//            for (int i = 0; i < 5; i++) {
//                System.out.println("执行" + i);
//            }
//            System.out.println("执行结束....");
//        });
//        thread.start();
//        thread.join();//thread 加入 main thread 流程
//        System.out.println("main thread 结束");
//    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("开始执行....");
            for (int i = 0; i < 5; i++) {
                System.out.println("执行" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("执行结束....");
        });
        thread.start();
        thread.join(4000);//thread 加入 main thread 流程
        System.out.println("main thread 结束");
    }

}
