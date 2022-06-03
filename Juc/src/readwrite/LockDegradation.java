package readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ： CodeWater
 * @create ：2022-06-03-18:04
 * @Function Description ：演示锁降级：写锁变读锁
 * 
 */
public class LockDegradation {
    
    public static void main( String[] args ) {
        //可重入读写锁对象
        ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
        //读锁
        ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
        //写锁
        ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();
        

        //锁降级
        //1 获取写锁
        writeLock.lock();
        System.out.println( "----------codewater-----------" );

        //2 获取读锁
        readLock.lock();
        System.out.println( "-----------read................" );

        //3 释放写锁
        writeLock.unlock();

        //4 释放读锁
        readLock.unlock();
    }
    
}
