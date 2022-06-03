package juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author ： CodeWater
 * @create ：2022-06-03-0:00
 * @Function Description ：演示CountDownLatch:减少计数
 * 情景： //6个同学陆续离开教室之后，班长锁门
 */
public class CountDownLatchDemo {
    
    public static void main(String[] args) throws InterruptedException {
        //创建CountDownLatch对象，设置初始值
        CountDownLatch countDownLatch = new CountDownLatch( 6 );

        //6个同学陆续离开教室之后
        for( int i = 0 ; i < 6 ; i++ ){
            new Thread( () -> {
                System.out.println( Thread.currentThread().getName() + "号同学离开了教室。。" );
                
                //计数  -1
                countDownLatch.countDown();
            }, String.valueOf( i ) ).start();
        }
        
        //等待  知道计数器减到0为止才往下继续执行
        countDownLatch.await();
        
        System.out.println( Thread.currentThread().getName() + "班长锁门走人。。。" );
    }
}
