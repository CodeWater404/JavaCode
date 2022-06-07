package rabbitmq.six;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import rabbitmq.util.RabbitMqUtils;

/**
 * @author ： CodeWater
 * @create ：2022-06-07-21:25
 * @Function Description ：Direct exchange演示
 * 消费者2
 */
public class ReceiveLogsDirect02 {
    public static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        channel.exchangeDeclare( EXCHANGE_NAME , BuiltinExchangeType.DIRECT  );
        channel.queueDeclare( "disk" ,false , false , false , null );
        channel.queueBind( "disk" , EXCHANGE_NAME , "error" );
        
        //接受消息
        DeliverCallback deliverCallback = (consumerTag , message) ->{
            System.out.println( "ReceiveLogs2222控制台打印接收到的消息" + new String( message.getBody() , "utf-8" ) );
        };

        //消费者取消消息时间回调接口
        channel.basicConsume( "disk" , true , deliverCallback , consumerTag -> {} );
    }
}
