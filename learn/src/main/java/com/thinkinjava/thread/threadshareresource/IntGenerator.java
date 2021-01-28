package main.java.com.thinkinjava.thread.threadshareresource;

/**
 * @Author 程杰
 * @Date 2021/1/23 14:56
 * @Version 1.0
 */
public abstract class IntGenerator {

    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel(){
        this.canceled = true;
    }

    public boolean isCanceled(){
        return canceled;
    }

}
