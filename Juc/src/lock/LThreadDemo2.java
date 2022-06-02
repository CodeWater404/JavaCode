package lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ： CodeWater
 * @create ：2022-06-02-20:53
 * @Function Description ：线程键定制化通信： 让线程按照指定顺序运行
 * 线程A先打印5次------B打印10次-------------C打印15次
 * 轮数有输入决定
 */

//第一步 创建资源类
class ShareResource{
    //定义标志位  1AA  2BB  3CC
    private int flag = 1 ; 

    //创建Lock锁
    private Lock lock = new ReentrantLock();

    //创建三个condition
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    //打印5次，参数第几轮
    public void print5( int loop ) throws InterruptedException {
        //上锁
        lock.lock();
        try{
            //判断
            while( flag != 1 ){
                //等待
                c1.await();
            }
            //干活
            for( int i = 0 ; i < 5 ; i++ ){
                System.out.println( Thread.currentThread().getName() + "::" + i + ":轮数： " + loop  );
            }
            //通知
            flag = 2 ;//修改标志位 2
            c2.signal();//通知BB线程
            
        }finally{
            //释放锁
            lock.unlock();
        }
    }
    
    //打印10次，参数第几轮
    public void print10( int loop ) throws InterruptedException {
        lock.lock();
        try{
            while( flag != 2 ){
                c2.await();
            }
            for( int i = 0 ; i < 10 ; i++ ){
                System.out.println( Thread.currentThread().getName() + "::" + i + ":轮数：" + loop );
            }
            //修改标志位
            flag = 3;
            c3.signal();//通知CC线程
        }finally{
            lock.unlock();
        }
    }
    
    //打印15次，参数第几轮
    public void print15( int loop ) throws InterruptedException {
        lock.lock();
        try{
            while( flag != 3 ){
                c3.await();
            }
            for( int i = 0 ; i < 15 ; i++ ){
                System.out.println( Thread.currentThread().getName() + "::" + i + ": 轮数：" + loop );
                
            }
            //修改标志位
            flag = 1 ;
            // 通知AA线程
            c1.signal();
        }finally{
            lock.unlock();
        }
    }
}


public class LThreadDemo2 {
    public static void main( String[] args ) {
        ShareResource shareResource = new ShareResource();
        new Thread( () -> {
            for( int i = 1 ; i <= 10 ; i++ ){
                try{
                    shareResource.print5(i);
                }catch( InterruptedException e ){
                    e.printStackTrace();
                }
            }
        } , "AA" ).start();

        new Thread( () -> {
            for( int i = 1 ; i <= 10 ; i++ ){
                try{
                    shareResource.print10(i);
                }catch( InterruptedException e ){
                    e.printStackTrace();
                }
            }
        } , "BB" ).start();

        new Thread( () -> {
            for( int i = 1 ; i <= 10 ; i++ ){
                try{
                    shareResource.print15(i);
                }catch( InterruptedException e ){
                    e.printStackTrace();
                }
            }
        } , "CC" ).start();
    }    
}
