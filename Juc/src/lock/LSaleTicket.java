package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ： CodeWater
 * @create ：2022-06-02-16:40
 * @Function Description ：使用lock接口来实现卖票
 * 1. lock是一个接口， 手动上和释放。 发生异常可能会死锁
 * 2. synchronized是一个关键字，自动上锁和释放
 */

//第一步  创建资源类，定义属性和和操作方法
class LTicket {
    //票数量
    private int number = 30;

    //创建可重入锁   lock的一个实现类
    private final ReentrantLock lock = new ReentrantLock();

    //卖票方法
    public void sale(){
        //上锁
        lock.lock();
        try{
            //判断是否有票
            if( number > 0 ){
                System.out.println( Thread.currentThread().getName() + "卖出了：" + (number--) + ",还剩：" + number );
            }
            
        }finally{
            //解锁
            lock.unlock();
        }
    }
} 

public class LSaleTicket {

    //第二步 创建多个线程，调用资源类的操作方法
    //创建三个线程
    public static void main(String[] args){
        LTicket ticket = new LTicket();
        new Thread( () -> {
            for( int i = 0 ; i < 40 ; i++ ){
                ticket.sale();
            }
        } , "AA").start(); //线程的创建是不确定的，因为他内部用的native

        new Thread( () -> {
            for( int i = 0 ; i < 40 ; i++ ){
                ticket.sale();
            }
        } , "BB" ).start();

        new Thread( () -> {
            for( int i = 0 ; i < 40 ; i++ ){
                ticket.sale() ;
            }
        } , "CC" ).start();
        
    }
    
}
