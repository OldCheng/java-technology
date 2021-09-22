package main.java.com.introduction.thread.multi_thread.prctice;

import java.util.stream.IntStream;

public class Test1 {
    public static class T1 extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println(
                    Thread.currentThread().getName()+"   "+
                    Thread.currentThread().getPriority());
        }
    }

    public static void main(String[] args) {
        IntStream.range(1, 10).forEach(i -> {
            Thread thread = new Thread(new T1());
            thread.setName("asd+"+i);
            //thread.setPriority(i);
            thread.start();
        });
    }
}
