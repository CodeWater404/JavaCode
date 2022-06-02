package sync;

import java.util.concurrent.TimeUnit;

/**
 * @author ： CodeWater
 * @create ：2022-06-02-23:08
 * @Function Description ：演示死锁
 * A线程已经持有a，又想获取b
 * B线程已经持有b，又想获取a
 */
public class DeadLock {
    
    //创建两个对象
    static Object a = new Object();
    static Object b = new Object();
    
    public static void main(String[] args) {
        new Thread( () -> {
            synchronized( a ){
                System.out.println(Thread.currentThread().getName()+" 持有锁a，试图获取锁b");
                try{
                    //为了显示出效果，睡眠1秒。 因为线程创建的顺序不定，所以这里为了确定顺序
                    TimeUnit.SECONDS.sleep( 1 );
                }catch( InterruptedException e ){
                    e.printStackTrace();
                }
                synchronized( b ){
                    System.out.println(Thread.currentThread().getName()+" 获取锁b");
                }
            }
        } , "A" ).start();
        
        new Thread( () -> {
            synchronized( b ){
                System.out.println(Thread.currentThread().getName()+" 持有锁b，试图获取锁a");
                try{
                    TimeUnit.SECONDS.sleep( 1 );
                }catch (InterruptedException e ){
                    e.printStackTrace();
                }
                synchronized( a ){
                    System.out.println(Thread.currentThread().getName()+" 获取锁a");
                }
            }
        } , "B" ).start();
        
    }
}
