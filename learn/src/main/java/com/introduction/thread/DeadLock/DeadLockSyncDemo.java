package main.java.com.introduction.thread.DeadLock;

public class DeadLockSyncDemo {
    public static void main(String[] args) {
        ResourceSync resources1 = new ResourceSync("resource1",10);
        ResourceSync resources2 = new ResourceSync("resource2",20);

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                //System.out.println("res1111 thread "+i);
                resources1.cooperate(resources2);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                //System.out.println("res222 thread "+ i);
                resources2.cooperate(resources1);
            }
        }).start();

    }
}
