package main.java.com.introduction.thread.readWriteLock;

import java.util.Arrays;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * readLock：
 * ReentrantReadWriteLock.ReadLock 操作 了 Lock 接口 ， 调用其 lock()方法时，
 * 若没有任何 ReentrantReadWriteLock.WriteLock 调用过 lock()方法， 也就是没有任何写入锁定时，就可以取 得读取锁定。
 *
 * writeLock：
 * ReentrantReadWriteLock.WriteLock 操作了 Lock 接口，调用其 lock()方法时，
 * 若没有任何 ReentrantReadWriteLock.ReadLock 或 ReentrantReadWriteLock. WriteLock 调用过 lock()方法，
 * 也就是没有任何读取或写入锁定 时， 才可 以取得写入锁定。
 * @param <E>
 */
public class ArrayListSync<E> {

    private ReadWriteLock lock = new ReentrantReadWriteLock(); // 使用readwritelock

    private Object[] elems;

    private int next;

    public ArrayListSync() {
        this(16);
    }

    public ArrayListSync(int capacity) {
        elems = new Object[capacity];
    }

    public void add(E elem) {
        lock.writeLock().lock();// 取得写入锁
        try {
            if (next == elems.length) {
                elems = Arrays.copyOf(elems, elems.length * 2);
            }
            elems[next++] = elem;
        } finally {
            lock.writeLock().unlock();// 解除写入锁
        }
    }

    public E get(int index) {
        lock.readLock().lock();
        try {
            return (E) elems[index];
        } finally {
            lock.readLock().unlock();
        }
    }

    public int size() {
        lock.readLock().lock(); // 取得读取锁
        try {
            return next;
        } finally {
            lock.readLock().unlock();//解除读取锁
        }
    }
}
