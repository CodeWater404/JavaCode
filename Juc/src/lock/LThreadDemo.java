package lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ： CodeWater
 * @create ：2022-06-02-20:34
 * @Function Description ：线程间的通信: +1 和-1动作交替进行
 * -------------------------使用lock实现-----------------
 */

//第一步 创建资源类，定义属性和操作方法
class Share{
    private int number = 0;

    //创建Lock
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    
    //+1
    public void incr() throws InterruptedException {
        //上锁
        lock.lock();
        try{
            //判断 只有等于0才能通过
            while( number != 0 ){
                condition.await();
            }
            //干活
            number++;
            System.out.println( Thread.currentThread().getName() + ":: " + number );
            
            //通知
            condition.signalAll();
        }finally{
            lock.unlock();
        }
    }
    
    //-1
    public void decr() throws InterruptedException {
        lock.lock();
        try{
            while( number != 1 ){
                condition.await();
            }
            number--;
            System.out.println( Thread.currentThread().getName() + "::" + number  );
            
            condition.signalAll();
        }finally{
            lock.unlock();
        }
    } 
    
}


public class LThreadDemo {
    
    public static void main(String[] args ) {
        Share share = new Share();
        new Thread( () -> {
            for( int i = 0 ; i < 10 ; i++ ){
                try{
                    share.incr();
                }catch ( InterruptedException e ){
                    e.printStackTrace();
                }
            }
        } , "AA" ).start();

        new Thread( () -> {
            for( int i = 0 ; i < 10 ; i++ ){
                try{
                    share.decr();
                }catch ( InterruptedException e ){
                    e.printStackTrace();
                }
            }
        } , "BB" ).start();

        new Thread( () -> {
            for( int i = 0 ; i < 10 ; i++ ){
                try{
                    share.incr();
                }catch ( InterruptedException e ){
                    e.printStackTrace();
                }
            }
        } , "CC" ).start();

        new Thread( () -> {
            for( int i = 0 ; i < 10 ; i++ ){
                try{
                    share.decr();
                }catch ( InterruptedException e ){
                    e.printStackTrace();
                }
            }
        } , "DD" ).start();
        
    }
    
}
