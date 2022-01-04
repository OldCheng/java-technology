package main.java.com.introduction.thread.deadLock;

public class ResolveDeadLockDemo {
    public static void main(String[] args) {
        ResourceLock resourceLock1 = new ResourceLock("resource1");
        ResourceLock resourceLock2 = new ResourceLock("resource2");

        new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                resourceLock1.cooperate(resourceLock2);
            }
        }).start();

        new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                resourceLock2.cooperate(resourceLock1);
            }
        }).start();

    }
}
