package queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author ： CodeWater
 * @create ：2022-06-03-19:30
 * @Function Description ：演示阻塞队列的常用方法
 */
public class BlockingQueueDemo {
    
    public static void main(String[] args) throws InterruptedException {
        //创建指定长度的阻塞队列 array基于数组的
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        //第一组add remove
//        System.out.println( blockingQueue.add("a"));
//        System.out.println( blockingQueue.add("b"));
//        System.out.println( blockingQueue.add("c"));
////        System.out.println( blockingQueue.add("d"));
//
//        System.out.println( blockingQueue.remove());
//        System.out.println( blockingQueue.remove());
//        System.out.println( blockingQueue.remove());
//        System.out.println( blockingQueue.remove());
        
        //第二组----------------------添加（取出）超长度会返回true/false
//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("b"));
//        System.out.println(blockingQueue.offer("c"));
////        System.out.println(blockingQueue.offer("d"));
//
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
        
        //第三组----------------------添加（取出）超长度会阻塞，一直卡住
//        blockingQueue.put("a");
//        blockingQueue.put("b");
//        blockingQueue.put("c");
////        blockingQueue.put("d");
//
//        System.out.println( blockingQueue.take());
//        System.out.println( blockingQueue.take());
//        System.out.println( blockingQueue.take());
//        System.out.println( blockingQueue.take());
        
        //第四组----------------------添加（取出）超长度会按照超时时间而停止
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d", 3L , TimeUnit.SECONDS)  );
    }
}
