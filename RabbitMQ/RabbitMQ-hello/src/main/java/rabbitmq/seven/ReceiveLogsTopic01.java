package rabbitmq.seven;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import rabbitmq.util.RabbitMqUtils;

/**
 * @author ： CodeWater
 * @create ：2022-06-07-22:50
 * @Function Description ：topic模式演示：可以指定发送给特定的某个或者某些队列（fanout是全部，direct是某个，不能多个）
 * 消费者q1
 */
public class ReceiveLogsTopic01 {
    private static final String EXCHANGE_NAME = "topic_logs" ;

    public static void main(String[] args)  throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        channel.exchangeDeclare( EXCHANGE_NAME , "topic" );
        //声明Q1队列与绑定关系
        String queueName = "Q1";
        channel.queueDeclare( queueName , false , false ,false , null );
        channel.queueBind( queueName , EXCHANGE_NAME , "*.orange.*" );
        System.out.println( "等待接收消息。。" );
        DeliverCallback deliverCallback = ( consumerTag , message) ->{
            System.out.println( new String( message.getBody() , "utf-8") );
            System.out.println("接受队列：" + queueName + "  绑定键： " + message.getEnvelope().getRoutingKey() );
        };
        
        channel.basicConsume( queueName , true , deliverCallback, consumerTag -> {} );
    }
}
