package main.java.com.introduction.thread.produceandconsumer.sync;

public class Producer implements Runnable{

    private Resource resource;

    public Producer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            resource.a();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
