package rabbitmq.three;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import rabbitmq.util.RabbitMqUtils;

import java.util.Scanner;

/**
 * @author ： CodeWater
 * @create ：2022-06-06-0:11
 * @Function Description ：生产者
 * 演示： 消息在手动应答时是不丢失，放回队列中重新消费
 * 
 */
public class Task2 {
    public static final String TASK_QUEUE_NAME = "ack_queue";
    
    public static void main(String[] args)  throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        //开启发布确认
        channel.confirmSelect();
        //队列持久化
        boolean durable = true;
        //声明队列
        channel.queueDeclare( TASK_QUEUE_NAME , durable , false , false , null );
        Scanner sc = new Scanner( System.in ) ;
        while( sc.hasNext() ){
            String message = sc.next();
            //MessageProperties.PERSISTENT_TEXT_PLAIN消息持久化
            channel.basicPublish( "" , TASK_QUEUE_NAME , MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes( "utf-8") );
            System.out.println("生产者发送消息：" + message );
        }
    }
}
