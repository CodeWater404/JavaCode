package rabbitmq.four;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;
import rabbitmq.util.RabbitMqUtils;

import java.util.UUID;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author ： CodeWater
 * @create ：2022-06-06-16:35
 * @Function Description ：
 * 发布确认：
 *      1、单个确认
 *      2、批量确认
 *      3、异步批量确认
 */
public class ConfirmMessage {

    //批量发消息的个数
    public static final int MESSAGE_COUNT = 1000;
    
    public static void main(String[] args) throws Exception {
        //单个确认   722ms----615我的
//        ConfirmMessage.publishMessageIndividually();
        //批量确认   111ms
//        ConfirmMessage.publishMessageBatch();
        //异步确认  54ms
        ConfirmMessage.publishMessageAsync();
    }
    
    //单个确认
    public static void publishMessageIndividually() throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        //队列的声明
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare( queueName , true , false , false , null );
        
        //开启发布确认
        channel.confirmSelect();
        //开始时间
        long begin = System.currentTimeMillis();
        //批量发消息
        for( int i = 0 ; i < MESSAGE_COUNT ; i++ ){
            String message = i + "";
            channel.basicPublish( "" , queueName , null , message.getBytes() );
            //单个消息马上进行发布确认
            boolean flag = channel.waitForConfirms();
            if( flag ){
                System.out.println( "消息发送成功" );
            }
        }
        
        long end = System.currentTimeMillis();
        System.out.println( "发布" + MESSAGE_COUNT + "个单独确认消息，耗时" + (end - begin) + "ms" );
    }
    
    public static void publishMessageBatch() throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        //队列的声明
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare( queueName , true , false , false , null );

        //开启发布确认
        channel.confirmSelect();
        int batchSize = 100;
        //开始时间
        long begin = System.currentTimeMillis();
        //批量发消息
        for( int i = 0 ; i < MESSAGE_COUNT ; i++ ){
            String message = i + "";
            channel.basicPublish( "" , queueName , null , message.getBytes() );
            
            //判断到达100条消息的时候批量确认一次
            if( i % batchSize == 0 ){
                channel.waitForConfirms();
            }
            
        }

        long end = System.currentTimeMillis();
        System.out.println( "发布" + MESSAGE_COUNT + "个批量确认消息，耗时" + (end - begin) + "ms" );
    }

    public static void publishMessageAsync() throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        //队列的声明
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare( queueName , true , false , false , null );

        //开启发布确认
        channel.confirmSelect();
        
        /*线程安全有序的一个哈希表   适用于高并发的情况下
            1.经松的将序号与消息进行关联
            *2.经松批量删除条目   只要给到序号
            *3.支特高并发（多线程）
        * */
        ConcurrentSkipListMap<Long , String> outstandingConfirm = new ConcurrentSkipListMap<>();

        //消息确认成功回调函数
        ConfirmCallback ackCallback = (deliverTag , multiple) ->{
            if( multiple ){
            //2.删除已经确认的消息， 剩下的就是未确认的消息
                ConcurrentNavigableMap<Long , String> confirmed = 
                        outstandingConfirm.headMap( deliverTag );
                confirmed.clear();
            }else{
                outstandingConfirm.remove( deliverTag );
            }
            
            System.out.println("确认的消息：" + deliverTag);
        };
        //消息确认失败回调函数
        ConfirmCallback nackCallback = ( deliverTag , multiple ) ->{
            //3. 打印未确认的消息有哪些
            String message = outstandingConfirm.get( deliverTag );
            
            System.out.println("未确认的消息是：" + message + "::::未确认的消息：" + deliverTag );
        };
        
        
        /**
         * 添加一个异步确认的监听器方法参数解释：
         * 1.确认收到消息的回调
         * 2.未收到消息的回调
         */
        channel.addConfirmListener(ackCallback , nackCallback);
        //开始时间
        long begin = System.currentTimeMillis();
        //批量发消息
        for( int i = 0 ; i < MESSAGE_COUNT ; i++ ){
            String message = i + "";
            channel.basicPublish( "" , queueName , null , message.getBytes() );
            //1. 记录所有要发送的消息，消息总和
            outstandingConfirm.put( channel.getNextPublishSeqNo() , message );
        }

        long end = System.currentTimeMillis();
        System.out.println( "发布" + MESSAGE_COUNT + "个异步确认消息，耗时" + (end - begin) + "ms" );
    }
}
