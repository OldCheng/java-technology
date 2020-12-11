package main.java.com.introduction.thread.multi_thread.base;

/**
 * @Author 程杰
 * @Date 2020/12/10 10:38
 * @Version 1.0
 */
public class ThreadDemo extends Thread {

    //这里介绍一下Thread类的几个常用的方法：
    //
    //currentThread()：静态方法，返回对当前正在执行的线程对象的引用；
    //start()：开始执行线程的方法，java虚拟机会调用线程内的run()方法；
    //yield()：yield在英语里有放弃的意思，同样，这里的yield()指的是当前线程愿意让出对当前处理器的占用。这里需要注意的是，就算当前线程调用了yield()方法，程序在调度的时候，也还有可能继续运行这个线程的；
    //sleep()：静态方法，使当前线程睡眠一段时间；
    //join()：使当前线程等待另一个线程执行完毕之后再继续执行，内部调用的是Object类的wait方法实现的；

    @Override
    public void run() {
        System.out.println("继承thread----:"+Thread.currentThread().getName());
    }
}
