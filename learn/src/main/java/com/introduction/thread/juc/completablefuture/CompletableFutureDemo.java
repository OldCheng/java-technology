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
            System.out.println("1");
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {

            }
            System.out.println(Thread.currentThread() + "exit job1 , time -> " + System.currentTimeMillis());
            return 1.2;
        });

        // cf 关联的异步任务的返回值作为方法的入参，传入到thenApply 方法中
        // thenApply 这里实际创建了一个新的CompletableFuture实列
        CompletableFuture<String> cf2 = cf.thenApply((result) -> {
            System.out.println(Thread.currentThread() + "  start job2, time -> " + System.currentTimeMillis() +"---"+ result);
            System.out.println("1");
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {

            }
            System.out.println(Thread.currentThread() + "  exit job2 , time -> " + System.currentTimeMillis()+"---"+ result);
            return "test:" + result;
        });


        System.out.println("main thread start cf.get() ,time -> "+ System.currentTimeMillis());
        // 等待子任务执行完成
        System.out.println("run result -> "+ cf.get()+ " **"+System.currentTimeMillis());
        System.out.println("main thread start cf2.get() ,time -> "+ System.currentTimeMillis());
        System.out.println("run result -> "+ cf2.get()+ " **"+System.currentTimeMillis());
        System.out.println("main thread exit, time -> " +System.currentTimeMillis());
    }

    /**
     *
     * thenAccept / thenRun
     *
     * thenAccept 同 thenApply 接收上一个任务的返回值作为参数，但是无返回值；
     * thenRun 的方法没有入参，也买有返回值
     *
     * @throws Exception
     */
    @Test
    public void test7() throws Exception {
        ForkJoinPool pool=new ForkJoinPool();
        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread()+" start job1,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread()+" exit job1,time->"+System.currentTimeMillis());
            return 1.2;
        },pool);
        //cf关联的异步任务的返回值作为方法入参，传入到thenApply的方法中
        CompletableFuture cf2=cf.thenApply((result)->{
            System.out.println(Thread.currentThread()+" start job2,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread()+" exit job2,time->"+System.currentTimeMillis());
            return "test:"+result;
        }).thenAccept((result)-> { //接收上一个任务的执行结果作为入参，但是没有返回值
            System.out.println(Thread.currentThread()+" start job3,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(result);
            System.out.println(Thread.currentThread()+" exit job3,time->"+System.currentTimeMillis());
        }).thenRun(()->{ //无入参，也没有返回值
            System.out.println(Thread.currentThread()+" start job4,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println("thenRun do something");
            System.out.println(Thread.currentThread()+" exit job4,time->"+System.currentTimeMillis());
        });
        System.out.println("main thread start cf.get(),time->"+System.currentTimeMillis());
        //等待子任务执行完成
        System.out.println("run result->"+cf.get());
        System.out.println("main thread start cf2.get(),time->"+System.currentTimeMillis());
        //cf2 等待最后一个thenRun执行完成
        System.out.println("run result->"+cf2.get());
        System.out.println("main thread exit,time->"+System.currentTimeMillis());
    }

    /**
     * exceptionally
     *
     * exceptionally方法指定某个任务执行异常时执行的回调方法，
     * 会将抛出异常作为参数传递到回调方法中，
     * 如果该任务正常执行则会exceptionally方法返回的CompletionStage的result就是该任务正常执行的结果
     *
     *
     * 抛出异常后，只有cf2执行了，cf3没有执行。将上述示例中的if(true) 改成if(false)
     *
     * cf2没有指定，其result就是cf执行的结果，理论上cf2.get应该立即返回的，
     * 此处是等待了cf3，即job2执行完成后才返回，具体原因且待下篇源码分析时再做探讨
     * @throws Exception
     */
    @Test
    public void test8() throws Exception {
        ForkJoinPool pool=new ForkJoinPool();
        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread()+"job1 start,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            if(true){
                throw new RuntimeException("test");
            }else{
                System.out.println(Thread.currentThread()+"job1 exit,time->"+System.currentTimeMillis());
                return 1.2;
            }
        },pool);
        //cf执行异常时，将抛出的异常作为入参传递给回调方法
        CompletableFuture<Double> cf2= cf.exceptionally((param)->{
            System.out.println(Thread.currentThread()+" start,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println("error stack trace->");
            param.printStackTrace();
            System.out.println(Thread.currentThread()+" exit,time->"+System.currentTimeMillis());
            return -1.1;
        });
        //cf正常执行时执行的逻辑，如果执行异常则不调用此逻辑
        CompletableFuture cf3=cf.thenAccept((param)->{
            System.out.println(Thread.currentThread()+"job2 start,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println("param->"+param);
            System.out.println(Thread.currentThread()+"job2 exit,time->"+System.currentTimeMillis());
        });
        System.out.println("main thread start,time->"+System.currentTimeMillis());
        //等待子任务执行完成,此处无论是job2和job3都可以实现job2退出，主线程才退出，如果是cf，则主线程不会等待job2执行完成自动退出了
        //cf2.get时，没有异常，但是依然有返回值，就是cf的返回值
        System.out.println("run result->"+cf2.get());
        System.out.println("main thread exit,time->"+System.currentTimeMillis());
    }


    /**
     * whenComplete
     *
     * whenComplete是当某个任务执行完成后执行的回调方法，
     * 会将执行结果或者执行期间抛出的异常传递给回调方法，如果是正常执行则异常为null，
     * 回调方法对应的CompletableFuture的result和该任务一致，如果该任务正常执行，
     * 则get方法返回执行结果，如果是执行异常，则get方法抛出异常
     *
     *
     * @throws Exception
     */
    @Test
    public void test9() throws Exception {
        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread()+"job1 start,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            if(false){
                throw new RuntimeException("test");
            }else{
                System.out.println(Thread.currentThread()+"job1 exit,time->"+System.currentTimeMillis());
                return 1.2;
            }
        });
        //cf执行完成后会将执行结果和执行过程中抛出的异常传入回调方法，如果是正常执行的则传入的异常为null
        CompletableFuture<Double> cf2=cf.whenComplete((a,b)->{
            System.out.println(Thread.currentThread()+"job2 start,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            if(b!=null){
                System.out.println("error stack trace->");
                b.printStackTrace();
            }else{
                System.out.println("run succ,result->"+a);
            }
            System.out.println(Thread.currentThread()+"job2 exit,time->"+System.currentTimeMillis());
        });
        //等待子任务执行完成
        System.out.println("main thread start wait,time->"+System.currentTimeMillis());
        //如果cf是正常执行的，cf2.get的结果就是cf执行的结果
        //如果cf是执行异常，则cf2.get会抛出异常
        System.out.println("run result->"+cf2.get());
        System.out.println("main thread exit,time->"+System.currentTimeMillis());
    }


    /**
     * handle
     * 跟whenComplete基本一致，区别在于handle的回调方法有返回值，
     * 且handle方法返回的CompletableFuture的result是回调方法的执行结果或者回调方法执行期间抛出的异常，
     * 与原始CompletableFuture的result无关了
     *
     * @throws Exception
     */
    @Test
    public void test10() throws Exception {
        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread()+"job1 start,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            if(true){
                throw new RuntimeException("test");
            }else{
                System.out.println(Thread.currentThread()+"job1 exit,time->"+System.currentTimeMillis());
                return 1.2;
            }
        });
        //cf执行完成后会将执行结果和执行过程中抛出的异常传入回调方法，如果是正常执行的则传入的异常为null
        CompletableFuture<String> cf2=cf.handle((a,b)->{
            System.out.println(Thread.currentThread()+"job2 start,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            if(b!=null){
                System.out.println("error stack trace->");
                b.printStackTrace();
            }else{
                System.out.println("run succ,result->"+a);
            }
            System.out.println(Thread.currentThread()+"job2 exit,time->"+System.currentTimeMillis());
            if(b!=null){
                return "run error";
            }else{
                return "run succ";
            }
        });
        //等待子任务执行完成
        System.out.println("main thread start wait,time->"+System.currentTimeMillis());
        //get的结果是cf2的返回值，跟cf没关系了
        System.out.println("run result->"+cf2.get());
        System.out.println("main thread exit,time->"+System.currentTimeMillis());
    }


    /**
     * thenCombine / thenAcceptBoth / runAfterBoth
     *
     * 这三个方法都是将两个CompletableFuture组合起来，只有这两个都正常执行完了才会执行某个任务，
     * 区别在于，thenCombine会将两个任务的执行结果作为方法入参传递到指定方法中，且该方法有返回值；
     * thenAcceptBoth同样将两个任务的执行结果作为方法入参，但是无返回值；runAfterBoth没有入参，
     * 也没有返回值。注意两个任务中只要有一个执行异常，则将该异常信息作为指定任务的执行结果
     *
     * @throws Exception
     */
    @Test
    public void test11() throws Exception {
        ForkJoinPool pool=new ForkJoinPool();
        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread()+" start job1,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread()+" exit job1,time->"+System.currentTimeMillis());
            return 1.2;
        });
        CompletableFuture<Double> cf2 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread()+" start job2,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread()+" exit job2,time->"+System.currentTimeMillis());
            return 3.2;
        });
        //cf和cf2的异步任务都执行完成后，会将其执行结果作为方法入参传递给cf3,且有返回值
        CompletableFuture<Double> cf3=cf.thenCombine(cf2,(a,b)->{
            System.out.println(Thread.currentThread()+" start job3,time->"+System.currentTimeMillis());
            System.out.println("job3 param a->"+a+",b->"+b);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread()+" exit job3,time->"+System.currentTimeMillis());
            return a+b;
        });

        //cf和cf2的异步任务都执行完成后，会将其执行结果作为方法入参传递给cf3,无返回值
        CompletableFuture cf4=cf.thenAcceptBoth(cf2,(a,b)->{
            System.out.println(Thread.currentThread()+" start job4,time->"+System.currentTimeMillis());
            System.out.println("job4 param a->"+a+",b->"+b);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread()+" exit job4,time->"+System.currentTimeMillis());
        });

        //cf4和cf3都执行完成后，执行cf5，无入参，无返回值
        CompletableFuture cf5=cf4.runAfterBoth(cf3,()->{
            System.out.println(Thread.currentThread()+" start job5,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("cf5 do something");
            System.out.println(Thread.currentThread()+" exit job5,time->"+System.currentTimeMillis());
        });

        System.out.println("main thread start cf.get(),time->"+System.currentTimeMillis());
        //等待子任务执行完成
        System.out.println("cf run result->"+cf.get());
        System.out.println("main thread start cf5.get(),time->"+System.currentTimeMillis());
        System.out.println("cf5 run result->"+cf5.get());
        System.out.println("main thread exit,time->"+System.currentTimeMillis());
    }


    /**
     * applyToEither / acceptEither / runAfterEither
     * 这三个方法都是将两个CompletableFuture组合起来，只要其中一个执行完了就会执行某个任务，
     * 其区别在于applyToEither会将已经执行完成的任务的执行结果作为方法入参，并有返回值；
     * acceptEither同样将已经执行完成的任务的执行结果作为方法入参，但是没有返回值；runAfterEither没有方法入参，也没有返回值。
     * 注意两个任务中只要有一个执行异常，则将该异常信息作为指定任务的执行结果
     *
     * @throws Exception
     */
    @Test
    public void test12() throws Exception {
        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread()+" start job1,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread()+" exit job1,time->"+System.currentTimeMillis());
            return 1.2;
        });
        CompletableFuture<Double> cf2 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread()+" start job2,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread()+" exit job2,time->"+System.currentTimeMillis());
            return 3.2;
        });
        //cf和cf2的异步任务都执行完成后，会将其执行结果作为方法入参传递给cf3,且有返回值
        CompletableFuture<Double> cf3=cf.applyToEither(cf2,(result)->{
            System.out.println(Thread.currentThread()+" start job3,time->"+System.currentTimeMillis());
            System.out.println("job3 param result->"+result);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread()+" exit job3,time->"+System.currentTimeMillis());
            return result;
        });

        //cf和cf2的异步任务都执行完成后，会将其执行结果作为方法入参传递给cf3,无返回值
        CompletableFuture cf4=cf.acceptEither(cf2,(result)->{
            System.out.println(Thread.currentThread()+" start job4,time->"+System.currentTimeMillis());
            System.out.println("job4 param result->"+result);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread()+" exit job4,time->"+System.currentTimeMillis());
        });

        //cf4和cf3都执行完成后，执行cf5，无入参，无返回值
        CompletableFuture cf5=cf4.runAfterEither(cf3,()->{
            System.out.println(Thread.currentThread()+" start job5,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("cf5 do something");
            System.out.println(Thread.currentThread()+" exit job5,time->"+System.currentTimeMillis());
        });

        System.out.println("main thread start cf.get(),time->"+System.currentTimeMillis());
        //等待子任务执行完成
        System.out.println("cf run result->"+cf.get());
        System.out.println("main thread start cf5.get(),time->"+System.currentTimeMillis());
        System.out.println("cf5 run result->"+cf5.get());
        System.out.println("main thread exit,time->"+System.currentTimeMillis());
    }

    /**
     * thenCompose
     *
     *  thenCompose方法会在某个任务执行完成后，将该任务的执行结果作为方法入参然后执行指定的方法，
     *  该方法会返回一个新的CompletableFuture实例，如果该CompletableFuture实例的result不为null，
     *  则返回一个基于该result的新的CompletableFuture实例；如果该CompletableFuture实例为null，则，然后执行这个新任务
     *
     * @throws Exception
     */
    @Test
    public void test13() throws Exception {
        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread()+" start job1,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread()+" exit job1,time->"+System.currentTimeMillis());
            return 1.2;
        });
        CompletableFuture<String> cf2= cf.thenCompose((param)->{
            System.out.println(Thread.currentThread()+" start job2,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread()+" exit job2,time->"+System.currentTimeMillis());
            return CompletableFuture.supplyAsync(()->{
                System.out.println(Thread.currentThread()+" start job3,time->"+System.currentTimeMillis());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
                System.out.println(Thread.currentThread()+" exit job3,time->"+System.currentTimeMillis());
                return "job3 test";
            });
        });
        System.out.println("main thread start cf.get(),time->"+System.currentTimeMillis());
        //等待子任务执行完成
        System.out.println("cf run result->"+cf.get());
        System.out.println("main thread start cf2.get(),time->"+System.currentTimeMillis());
        System.out.println("cf2 run result->"+cf2.get());
        System.out.println("main thread exit,time->"+System.currentTimeMillis());
    }

    /**
     * allOf / anyOf
     *
     *  allOf返回的CompletableFuture是多个任务都执行完成后才会执行，只有有一个任务执行异常，
     *  则返回的CompletableFuture执行get方法时会抛出异常，如果都是正常执行，则get返回null。
     *
     *  主线程等待最后一个job1执行完成后退出。anyOf返回的CompletableFuture是多个任务只要其中一个执行完成就会执行，
     *  其get返回的是已经执行完成的任务的执行结果，如果该任务执行异常，则抛出异常。将上述测试用例中allOf改成anyOf后，
     *
     * @throws Exception
     */
    @Test
    public void test14() throws Exception {
        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread()+" start job1,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread()+" exit job1,time->"+System.currentTimeMillis());
            return 1.2;
        });
        CompletableFuture<Double> cf2 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread()+" start job2,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread()+" exit job2,time->"+System.currentTimeMillis());
            return 3.2;
        });
        CompletableFuture<Double> cf3 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread()+" start job3,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(1300);
            } catch (InterruptedException e) {
            }
//            throw new RuntimeException("test");
            System.out.println(Thread.currentThread()+" exit job3,time->"+System.currentTimeMillis());
            return 2.2;
        });
        //allof等待所有任务执行完成才执行cf4，如果有一个任务异常终止，则cf4.get时会抛出异常，都是正常执行，cf4.get返回null
        //anyOf是只有一个任务执行完成，无论是正常执行或者执行异常，都会执行cf4，cf4.get的结果就是已执行完成的任务的执行结果
        CompletableFuture cf4=CompletableFuture.allOf(cf,cf2,cf3).whenComplete((a,b)->{
            if(b!=null){
                System.out.println("error stack trace->");
                b.printStackTrace();
            }else{
                System.out.println("run succ,result->"+a);
            }
        });

        System.out.println("main thread start cf4.get(),time->"+System.currentTimeMillis());
        //等待子任务执行完成
        System.out.println("cf4 run result->"+cf4.get());
        System.out.println("main thread exit,time->"+System.currentTimeMillis());

    }

}
