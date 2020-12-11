package main.java.com.introduction.thread.multi_thread.action;

import java.util.stream.IntStream;

/**
 * @Author 程杰
 * @Date 2020/12/10 15:00
 * @Version 1.0
 */

/**
 * Java多线程的等待/通知机制是基于Object类的wait()方法和notify(), notifyAll()方法来实现的。
 * notify()方法会随机叫醒一个正在等待的线程，而notifyAll()会叫醒所有正在等待的线程。
 * 前面我们讲到，一个锁同一时刻只能被一个线程持有。而假如线程A现在持有了一个锁lock并开始执行，它可以使用lock.wait()让自己进入等待状态。这个时候，lock这个锁是被释放了的。
 * 这时，线程B获得了lock这个锁并开始执行，它可以在某一时刻，使用lock.notify()，通知之前持有lock锁并进入等待状态的线程A，说“线程A你不用等了，可以往下执行了”。
 * 需要注意的是，这个时候线程B并没有释放锁lock，除非线程B这个时候使用lock.wait()释放锁，或者线程B执行结束自行释放锁，线程A才能得到lock锁。线程想等待子线程执行完毕后，获得子线程中的处理完的某个数据，就要用到join方法了。
 *
 * 这里需要强调一下：sleep方法是不会释放当前的锁的，而wait方法会。这也是最常见的一个多线程面试题。
 * 它们还有这些区别：
 * wait可以指定时间，也可以不指定；而sleep必须指定时间。
 * wait释放cpu资源，同时释放锁；sleep释放cpu资源，但是不释放锁，所以易死锁。
 * wait必须放在同步块或同步方法中，而sleep可以再任意位置
 */

public class WaitAndNotify {
    private static Object lock = new Object();

    public static void main(String[] args) {

        Thread thread1 = new Thread(() ->{
           synchronized (lock){
               IntStream.range(0,100).forEach(i ->{
                   System.out.println("name:"+Thread.currentThread().getName()+"  count:"+i);
                   try {
                       lock.notify();
                       lock.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               });
           }
        });

        Thread thread2 = new Thread(() ->{
            synchronized (lock){
                IntStream.range(0,100).forEach(i ->{
                    System.out.println("name:"+Thread.currentThread().getName()+"  count:"+i);
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        });

        thread1.start();

        thread2.start();
    }

}

