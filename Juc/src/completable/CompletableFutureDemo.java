package completable;

import java.util.concurrent.CompletableFuture;

/**
 * @author ： CodeWater
 * @create ：2022-06-03-21:12
 * @Function Description ：演示异步回调：找张三，不在，等他在的时候告知一下
 */
public class CompletableFutureDemo {
    public static void main(String[] args)  throws Exception {
        //异步调用 无返回值
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync( () ->{
            System.out.println( Thread.currentThread().getName() + ": CompletableFuture1" );
        });
        completableFuture1.get();

        //异步调用 有返回值
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync( () -> {
            System.out.println( Thread.currentThread().getName() + ": completableFuture2 " );
            //模拟异常
            int i = 1/0;
            
            return 1024;
        });

        completableFuture2.whenComplete( (t , u ) -> {
            System.out.println( "--------------t: " + t );//返回值.有异常时为空
            System.out.println( "--------------u:" + u );//异常信息
        }).get();
                
    }
}
