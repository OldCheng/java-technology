package main.java.com.thinkinjava.thread.daemon;

import java.util.concurrent.TimeUnit;

/**
 * @Author 程杰
 * @Date 2021/1/22 20:00
 * @Version 1.0
 */
public class DaemonDontRunFinally {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();

        /**
         * 当运行这段代码时，你将看到finally子句不会执行,但是注释掉setDaemon的调用，就会看到finally子句执行
         * 这种行为是正确的，即使你基于前面finally给出的承诺，并不希望出现这种行为，但情况仍将如此，当最后一个
         * 非后台线程终止时，后台线程会“突然”终止，因此一旦main()退出，jvm 就会立即关闭后台所有的后台线程
         * 而不会有任何你希望出现的确认形式，因为你不能以优雅的方式来关闭后台线程，所以他们几乎不是一个好的思想。
         * 非后台的 Executor 通常是一种更好的方式，因为 Executor 控制的所有任务可以同时被关闭
         *
         */
        //TimeUnit.MILLISECONDS.sleep(10000);
    }

}
