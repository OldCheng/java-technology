package main.java.com.introduction.thread.multi_thread.producerAndConsumer;

/**
 * @Author 程杰
 * @Date 2020/12/10 17:07
 * @Version 1.0
 */
public class Resource5 {

    private String name;

    private int count;

    private boolean flag;

    public synchronized void set(String name){
        while (flag) {
        //if(flag) {
            System.out.println("======producer======"+Thread.currentThread().getName()+"     ---"+flag);
            try {
                /***
                 * 如果原先wait再被唤醒继续执行的话从此处开始,
                 * 问题出在if判断句,因为t1醒了没有再次判断，直接就生产了；
                 * 同理，t3也是没有再次判断，就消费了。
                 */
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name=name+"--"+count;
        count++;
        System.out.println(Thread.currentThread().getName()+"...生产者..."+this.name);
        flag=true;
        this.notify();
    }

    public synchronized void get(){
        while (flag) {
        //if(!flag) {
            System.out.println("======consumer======"+Thread.currentThread().getName()+"     ---"+flag);
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"...消费者..."+this.name);
        flag=false;
        this.notify();
    }
}
