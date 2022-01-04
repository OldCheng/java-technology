package main.java.com.introduction.thread.produceandconsumer.sync;

public class Resource {

    public synchronized void a() throws InterruptedException {
        wait();
        System.out.println("aaaaaaaaaa");
    }

    public synchronized void b(){
        System.out.println("bbbbbbbbbbb");
    }
}
