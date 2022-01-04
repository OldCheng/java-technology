package main.java.com.introduction.thread.deadLock;

import java.util.concurrent.locks.ReentrantLock;

public class ResourceLock {

    private ReentrantLock lock = new ReentrantLock();

    private String name;

    public ResourceLock() {
    }

    public ResourceLock(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    void cooperate(ResourceLock r){
        while (true){
            try{
                if (lockMeAnd(r)){ // 取得目前与传入的Resource的lock的锁定
                    // 如果两个resource的lock都取得锁定，才执行资源整合
                    System.out.printf("%s 整合 %s 的资源%n", this.getName(), r.getName());
                    break;// 资源整合成功，离开循环
                }
            } finally {
                unLockMeAnd(r); // 解除目前与传入的resource的lock锁定
            }
        }
    }

    /**
     * tryLock(): tryLock()方法是有返回值的，返回值是Boolean类型。
     * 它表示的是用来尝试获取锁：成功获取则返回true；获取失败则返回false，这个方法无论如何都会立即返回。
     * 不会像synchronized一样，一个线程获取锁之后，其他锁只能等待那个线程释放之后才能有获取锁的机会
     *
     * 1、lock.isFair()方法用来判断lock锁是公平锁还是非公平锁。公平锁是指，线程获得锁的顺序是按其等待锁的先后顺序来的，
     * 先来先获得FIFO。反之，非公平锁则是线程随机获得锁的，lock默认是非公平锁。
     *
     * 2、lock.isHeldByCurrentThread()的作用是查询当前线程是否保持此锁定，和lock.hasQueueThread()不同的地方是：
     * lock.hasQueueThread(Thread thread)的作用是判断当前线程是否处于等待lock的状态。
     *
     * 3、lock.isLocked()的作用是查询此锁定是否由任意线程保持。
     * @param r
     * @return
     */
    private boolean lockMeAnd(ResourceLock r){
        return this.lock.tryLock() && r.lock.tryLock();
    }

    private void unLockMeAnd(ResourceLock r){
        if (this.lock.isHeldByCurrentThread()){
            this.lock.unlock();
        }
        if (r.lock.isHeldByCurrentThread()){
            r.lock.unlock();
        }
    }


}
