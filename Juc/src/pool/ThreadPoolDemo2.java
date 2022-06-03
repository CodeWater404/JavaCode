package pool;

import java.util.concurrent.*;

/**
 * @author ： CodeWater
 * @create ：2022-06-03-20:35
 * @Function Description ：自定义线程池
 * 超过最大办理线程数量会抛出异常
 */
public class ThreadPoolDemo2 {

    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2, 
                5 ,
                2L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3) ,
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        //10个顾客请求
        try{
            for( int i = 0 ; i < 10 ; i++ ){
                //执行
                threadPool.execute( () -> {
                    System.out.println( Thread.currentThread().getName() + "办理业务。" );
                });
            }
        }catch( Exception e ){
            e.printStackTrace();
        }finally{
            threadPool.shutdown();
        }
    }
    
}
