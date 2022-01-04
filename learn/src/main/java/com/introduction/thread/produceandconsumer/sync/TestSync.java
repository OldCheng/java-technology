package main.java.com.introduction.thread.produceandconsumer.sync;


public class TestSync {
    public static void main(String[] args) {
        Resource resource = new Resource();

        Producer p  = new Producer(resource);
        Consumer c = new Consumer(resource);

        new Thread(c).start();
        new Thread(p).start();

    }
}
