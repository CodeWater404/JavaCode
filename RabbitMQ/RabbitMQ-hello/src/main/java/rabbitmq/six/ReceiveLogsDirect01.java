package rabbitmq.six;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import rabbitmq.util.RabbitMqUtils;

/**
 * @author ： CodeWater
 * @create ：2022-06-07-20:58
 * @Function Description ：Direct exchange演示
 * 消费者1
 */
public class ReceiveLogsDirect01 {
    public static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        //声明交换机和队列
        channel.exchangeDeclare(EXCHANGE_NAME , BuiltinExchangeType.DIRECT );
        channel.queueDeclare( "console" , false , false , false , null );
        //绑定
        channel.queueBind( "console" , EXCHANGE_NAME, "info" );
        channel.queueBind( "console" , EXCHANGE_NAME , "warning" );
        
        //接收消息
        DeliverCallback deliverCallback = ( consumerTag , message )->{
            System.out.println("ReceiveLogs11111控制台打印接收到的消息： " + new String(message.getBody() , "utf-8" ));
        };
        
        //消费者取消消息时间回调接口
        channel.basicConsume( "console" , true , deliverCallback , consumerTag -> {} );
        
    }
}
