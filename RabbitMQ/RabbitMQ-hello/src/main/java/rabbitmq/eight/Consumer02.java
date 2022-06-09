package rabbitmq.eight;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import rabbitmq.util.RabbitMqUtils;

/**
 * @author ： CodeWater
 * @create ：2022-06-09-23:16
 * @Function Description ：演示死信
 * 消费者2 ：只负责死信队列的消费（消息过期；超出正常队列的长度；被消费者c1拒绝）
 * 
 */
public class Consumer02 {

    //死信队列名称
    public static final String DEAD_QUEUE = "dead_queue";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();

        System.out.println("等待接收消息。。。。。");

        DeliverCallback deliverCallback =  (consumerTag , message ) ->{
            System.out.println("Consumer2222接收到的消息是： " + new String( message.getBody() , "utf-8") );
        };
        
        channel.basicConsume( DEAD_QUEUE , true , deliverCallback , consumerTag -> {} );
        
    }
}
