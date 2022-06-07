package rabbitmq.seven;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import rabbitmq.util.RabbitMqUtils;

/**
 * @author ： CodeWater
 * @create ：2022-06-07-22:51
 * @Function Description ：
 */
public class ReceiveLogsTopic02 {
    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args)  throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        channel.exchangeDeclare( EXCHANGE_NAME , "topic" );
        String queueName = "Q2";
        channel.queueDeclare( queueName , false , false , false , null );
        channel.queueBind( queueName , EXCHANGE_NAME, "*.*.rabbit" );
        channel.queueBind( queueName , EXCHANGE_NAME , "lazy.#" );
        System.out.println("等待接收消息。。。。。");

        DeliverCallback deliverCallback = (consumerTag , message ) ->{
            System.out.println( new String( message.getBody() , "utf-8") );
            System.out.println("接受队列：" + queueName + "  绑定键： " + message.getEnvelope().getRoutingKey() );
        };
        
        channel.basicConsume( queueName , true, deliverCallback , consumer -> {} );
        
    }
}
