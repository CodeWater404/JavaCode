package rabbitmq.util;

/**
 * @author ： CodeWater
 * @create ：2022-06-06-0:26
 * @Function Description ：睡眠工具类
 */
public class SleepUtils {
    public static void sleep( int seconds ){
        try{
            Thread.sleep( seconds * 1000 );
        }catch( InterruptedException  e ){
            Thread.currentThread().interrupt();
        }
    }
}
