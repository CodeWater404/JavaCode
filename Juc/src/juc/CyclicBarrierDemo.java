package juc;

import java.util.concurrent.CyclicBarrier;

/**
 * @author ： CodeWater
 * @create ：2022-06-03-15:46
 * @Function Description ：juc辅助类CyclicBarrier
 * 当到达某一条件时才会执行，否则就一直等待。
 * 例子： 集齐7颗龙珠就能召唤神龙
 */
public class CyclicBarrierDemo {
    //创建固定值
    private static final int NUMBER = 7;

    public static void main(String[] args) {
        //创建CyclicBarrier
        CyclicBarrier cyclicBarrier = new CyclicBarrier( NUMBER , () -> {
            //达到条件之后要做的事。  ------这里就是召唤神龙
            System.out.println( "----------已经集齐7颗龙珠！！可以召唤神龙！！！--------------" );
            
        } );
        
        //集齐七颗龙珠过程 改成小于或者大于7的就会一直处于等待状态
        for( int i = 1 ; i <= 6 ; i++ ){
            new Thread( () -> {
                try{
                    System.out.println(Thread.currentThread().getName()+" 星龙被收集到了");
                    //等待
                    cyclicBarrier.await();
                }catch( Exception e ){
                    e.printStackTrace();
                }
            } , String.valueOf( i ) ).start();
        }
        
    }


}
