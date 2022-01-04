package main.java.com.introduction.thread.readWriteLock;

import java.util.Arrays;
import java.util.concurrent.locks.StampedLock;

/**
 * 前面介绍的ReadWriteLock可以解决多线程同时读，但只有一个线程能写的问题。
 * 如果我们深入分析ReadWriteLock，会发现它有个潜在的问题：如果有线程正在读，写线程需要等待读线程释放锁后才能获取写锁，即读的过程中不允许写，这是一种悲观的读锁。
 * 要进一步提升并发执行效率，Java 8引入了新的读写锁：StampedLock。
 * StampedLock和ReadWriteLock相比，改进之处在于：读的过程中也允许获取写锁后写入！这样一来，我们读的数据就可能不一致，所以，需要一点额外的代码来判断读的过程中是否有写入，这种读锁是一种乐观锁。
 * 乐观锁的意思就是乐观地估计读的过程中大概率不会有写入，因此被称为乐观锁。反过来，悲观锁则是读的过程中拒绝有写入，也就是写入必须等待。显然乐观锁的并发效率更高，但一旦有小概率的写入导致读取的数据不一致，需要能检测出来，再读一遍就行。
 *
 *  @param <E>
 */
public class ArrayListStampedLock<E> {

    private StampedLock lock = new StampedLock();//使用stampedLock

    private Object[] elems;

    private int next;

    public ArrayListStampedLock(int capacity) {
        elems = new Object[capacity];
    }

    public ArrayListStampedLock() {
        this(16);
    }

    public void add(E elem) {
        long stamp = lock.writeLock();
        try {
            if (next == elems.length) {
                elems = Arrays.copyOf(elems, elems.length * 2);
            }
            elems[next++] = elem;
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    public E get(int index) {
        long stamp = lock.tryOptimisticRead();//试着乐观读取锁定
        Object elem = elems[index];
        if (!lock.validate(stamp)) {//查询是否有排他锁
            stamp = lock.readLock();// 真正的读取锁定
            try {
                elem = elems[index];
            } finally {
                lock.unlockRead(stamp);//解除读取锁定
            }
        }
        return (E) elem;
    }

    public int size(){
        long stamp = lock.tryOptimisticRead();
        int size = next;
        if(!lock.validate(stamp)){
            stamp = lock.readLock();
            try{
                size = next;
            }finally {
                lock.unlockRead(stamp);
            }
        }
        return size;
    }
    /**
     * 和ReadWriteLock相比，写入的加锁是完全一样的，不同的是读取。
     * 注意到首先我们通过tryOptimisticRead()获取一个乐观读锁，并返回版本号。
     * 接着进行读取，读取完成后，我们通过validate()去验证版本号，如果在读取过程中没有写入，版本号不变，验证成功，我们就可以放心地继续后续操作。
     * 如果在读取过程中有写入，版本号会发生变化，验证将失败。在失败的时候，我们再通过获取悲观读锁再次读取。由于写入的概率不高，程序在绝大部分情况下可以通过乐观读锁获取数据，极少数情况下使用悲观读锁获取数据。
     * 可见，StampedLock把读锁细分为乐观读和悲观读，能进一步提升并发效率。但这也是有代价的：一是代码更加复杂，二是StampedLock是不可重入锁，不能在一个线程中反复获取同一个锁。
     * StampedLock还提供了更复杂的将悲观读锁升级为写锁的功能，它主要使用在if-then-update的场景：即先读，如果读的数据满足条件，就返回，如果读的数据不满足条件，再尝试写。
     */

}
