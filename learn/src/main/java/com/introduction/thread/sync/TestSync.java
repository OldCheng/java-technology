package main.java.com.introduction.thread.sync;

public class TestSync {
    public static void main(String[] args) {
        Resource resource = new Resource();

        Producer p  = new Producer(resource);
        Consumer c = new Consumer(resource);

        new Thread(p).start();
        new Thread(c).start();

    }
}
