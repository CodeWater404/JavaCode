package rabbitmq.eight;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import rabbitmq.util.RabbitMqUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ： CodeWater
 * @create ：2022-06-08-23:11
 * @Function Description ：演示死信场景
 * 消费者1：要关联正常的交换机、队列和死信交换机、队列
 * 
 */
public class Consumer01 {
    //普通交换机名称
    public static final String NORMAL_EXCHANGE = "normal_exchange";

    //死信交换机名称
    public static final String DEAD_EXCHANGE = "dead_exchange";

    //普通队列名称
    public static final String NORMAL_QUEUE = "normal_queue";

    //死信队列名称
    public static final String DEAD_QUEUE = "dead_queue";

    public static void main(String[] args)  throws Exception {
        Channel channel = RabbitMqUtils.getChannel();

        //声明死信和普通交换机 类型为 direct
        channel.exchangeDeclare( NORMAL_EXCHANGE , BuiltinExchangeType.DIRECT );
        channel.exchangeDeclare( DEAD_EXCHANGE , BuiltinExchangeType.DIRECT );
        
        //声明普通的队列
        Map<String , Object > arguments = new HashMap<>();
        //过期时间 10s=10000ms   这里消费者可以不设置，有生产方指定（比较灵活，一般生产方指定）
        //arguments.put( "x-message-ttl" , 10000 );
        //正常队列设置死信交换机
        arguments.put( "x-dead-letter-exchange" , DEAD_EXCHANGE );
        //设置死信的routing-key
        arguments.put( "x-dead-letter-routing-key" , "lisi" );
        //设置队列的长度 ， 超出改长度之后后面的消息就会走死信队列
//        arguments.put("x-max-length" , 6 );
        channel.queueDeclare( NORMAL_QUEUE , false , false , false , arguments );
        
        //声明死信队列
        channel.queueDeclare( DEAD_QUEUE , false , false , false, null );
        
        //绑定普通交换机和普通的队列
        channel.queueBind( NORMAL_QUEUE , NORMAL_EXCHANGE , "zhangsan" );

        //绑定死信交换机和死信的队列
        channel.queueBind( DEAD_QUEUE , DEAD_EXCHANGE , "lisi" );

        System.out.println("等待接收的消息");

        DeliverCallback deliverCallback = (consumerTag , message ) ->{
            String msg = new String( message.getBody() , "utf-8" );
            if( msg.equals("info5") ){
                System.out.println("consumer1接收的消息是：" + msg + "  , 此消息是被C1拒绝的" );
                //c1拒绝指定消息， 并且不放回普通的队列中去
                channel.basicReject( message.getEnvelope().getDeliveryTag() , false );
            }else{
                System.out.println( "consumer111接收的消息是： " + new String( message.getBody() , "utf-8") );
                //c1结合搜狐指定消息， 不批量应答
                channel.basicAck( message.getEnvelope().getDeliveryTag()  , false );
                
            }
        };
        //因为c1开启拒绝那个消息，所以需要关闭自动应答
//        channel.basicConsume( NORMAL_QUEUE , true , deliverCallback , consumerTag -> {} );
        channel.basicConsume( NORMAL_QUEUE , false , deliverCallback , consumerTag -> {} );
        
    }
    
    
}
