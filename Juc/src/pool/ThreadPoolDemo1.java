package pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ： CodeWater
 * @create ：2022-06-03-19:56
 * @Function Description ：线程池的使用方式
 */
public class ThreadPoolDemo1 {
    public static void main( String[] args ) {
        //一池五线程 5个
        ExecutorService threadPool1 = Executors.newFixedThreadPool( 5 );

        //一池一线程 1
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();

        //一池可扩容线程
        ExecutorService threadPool3 = Executors.newCachedThreadPool();

        //10个顾客请求
        try{
            for( int i = 0 ; i < 30 ; i++ ){
                //执行
                threadPool3.execute( () -> {
                    System.out.println( Thread.currentThread().getName() + "办理业务" );
                });
                
            }
        }catch( Exception e){
            e.printStackTrace();
        }finally{
            //关闭
            threadPool3.shutdown();
        }

    }
}
