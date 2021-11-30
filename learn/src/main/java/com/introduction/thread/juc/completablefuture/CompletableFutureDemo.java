package main.java.com.introduction.thread.juc.completablefuture;

import org.junit.Test;

import java.util.concurrent.*;

public class CompletableFutureDemo {
    public static void main(String[] args) {

    }

    /**
     *
     * 很多博客说使用不带等待时间限制的get方法时，
     * 如果子线程执行异常了会导致主线程长期阻塞，这其实是错误的，
     * 子线程执行异常时其异常会被捕获，然后修改任务的状态为异常结束并唤醒等待的主线程，
     * get方法判断任务状态发生变更，就终止等待了，并抛出异常，
     * 可参考《Java8 AbstractExecutorService 和 FutureTask 源码解析》中FutureTask的实现。
     * 将上述用例中if(false)改成if(true) ，执行结果如下：
     *
     * @throws ExecutionException
     * @throws InterruptedException
     * @throws TimeoutException
     */
    @Test
    public void test1() throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Double> cf = executorService.submit(() -> {
            System.out.println(Thread.currentThread() + "  start, time -> " + System.currentTimeMillis());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {

            }
            if (false) {
                throw new RuntimeException("test");
            } else {
                System.out.println(Thread.currentThread() + "exit, time -> " + System.currentTimeMillis());
                return 1.2;
            }
        });

        System.out.println("main thread start, time -> "+ System.currentTimeMillis());
        // 等待子任务执行完成，如果完成则直接返回结果
        // 如果子任务执行异常，则get方法会把之前捕获的异常重新抛出

        System.out.println("run result -> "+cf.get());
        System.out.println("main thread exit, time -> " +System.currentTimeMillis());
    }

    /**
     * supplyAsync / runAsync
     *
     * supplyAsync表示创建带返回值的异步任务的，
     * 相当于ExecutorService submit(Callable<T> task) 方法，
     * runAsync表示创建无返回值的异步任务，相当于ExecutorService submit(Runnable task)方法，
     * 这两方法的效果跟submit是一样的
     */
    @Test
    public void test2() throws ExecutionException, InterruptedException {
        // 创建异步线程任务，有返回值
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + "  start, time -> " + System.currentTimeMillis());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {

            }
            if (false) {
                throw new RuntimeException("test");
            } else {
                System.out.println(Thread.currentThread() + "exit, time -> " + System.currentTimeMillis());
                return 1.2;
            }
        });

        System.out.println("main thread start, time -> "+ System.currentTimeMillis());
        // 等待子任务执行完成，如果完成则直接返回结果
        // 如果子任务执行异常，则get方法会把之前捕获的异常重新抛出

        System.out.println("run result -> "+ cf.get());
        System.out.println("main thread exit, time -> " +System.currentTimeMillis());

    }

    @Test
    public void test3() throws ExecutionException, InterruptedException {
        // 创建异步线程任务，无返回值
        CompletableFuture cf = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread() + "  start, time -> " + System.currentTimeMillis());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {

            }
            if (false) {
                throw new RuntimeException("test");
            } else {
                System.out.println(Thread.currentThread() + "exit, time -> " + System.currentTimeMillis());
            }
        });

        System.out.println("main thread start, time -> "+ System.currentTimeMillis());
        // 等待子任务执行完成，如果完成则直接返回结果
        // 如果子任务执行异常，则get方法会把之前捕获的异常重新抛出

        System.out.println("run result -> "+ cf.get());
        System.out.println("main thread exit, time -> " +System.currentTimeMillis());

    }


    /**
     *
     *  supplyAsync / runAsync 这两方法各有一个重载版本，可以指定执行异步任务的Executor实现，
     *  如果不指定，默认使用ForkJoinPool.commonPool()，
     *  如果机器是单核的，则默认使用ThreadPerTaskExecutor，
     *  该类是一个内部类，每次执行execute都会创建一个新线程
     *
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void test4() throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        // 创建异步线程任务，无返回值
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + "  start, time -> " + System.currentTimeMillis());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {

            }
            if (false) {
                throw new RuntimeException("test");
            } else {
                System.out.println(Thread.currentThread() + "exit, time -> " + System.currentTimeMillis());
                return 1.2;
            }
        }, pool);

        System.out.println("main thread start, time -> "+ System.currentTimeMillis());
        // 等待子任务执行完成，如果完成则直接返回结果
        // 如果子任务执行异常，则get方法会把之前捕获的异常重新抛出

        System.out.println("run result -> "+ cf.get());
        System.out.println("main thread exit, time -> " +System.currentTimeMillis());
    }

    @Test
    public void test5() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // 创建异步线程任务，无返回值
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + "  start, time -> " + System.currentTimeMillis());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {

            }
            if (false) {
                throw new RuntimeException("test");
            } else {
                System.out.println(Thread.currentThread() + "exit, time -> " + System.currentTimeMillis());
                return 1.2;
            }
        }, executorService);

        System.out.println("main thread start, time -> "+ System.currentTimeMillis());
        // 等待子任务执行完成，如果完成则直接返回结果
        // 如果子任务执行异常，则get方法会把之前捕获的异常重新抛出

        System.out.println("run result -> "+ cf.get());
        System.out.println("main thread exit, time -> " +System.currentTimeMillis());
    }

    /**
     * 异步回调
     * thenApply / thenApplyAsync
     *
     *  thenApply 表示某个任务执行完成后执行的动作，
     *  即回调方法，会将该任务的执行结果即方法返回值作为入参传递到回调方法中
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void test6() throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();

        // 创建异步线程任务，有返回值
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + "  start job1, time -> " + System.currentTimeMillis());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {

            }
            System.out.println(Thread.currentThread() + "exit job1 , time -> " + System.currentTimeMillis());
            return 1.2;
        }, pool);

        // cf 关联的异步任务的返回值作为方法的入参，传入到thenApply 方法中
        // thenApply 这里实际创建了一个新的CompletableFuture实列
        CompletableFuture<String> cf2 = cf.thenApply((result) -> {
            System.out.println(Thread.currentThread() + "  start job2, time -> " + System.currentTimeMillis());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {

            }
            System.out.println(Thread.currentThread() + "  exit job2 , time -> " + System.currentTimeMillis());
            return "test:" + result;
        });


        System.out.println("main thread start cf.get() ,time -> "+ System.currentTimeMillis());
        // 等待子任务执行完成
        System.out.println("run result -> "+ cf.get());
        System.out.println("main thread start cf2.get() ,time -> "+ System.currentTimeMillis());
        System.out.println("run result -> "+ cf2.get());
        System.out.println("main thread exit, time -> " +System.currentTimeMillis());
    }




}
