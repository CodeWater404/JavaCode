package rabbitmq.eight;

import com.rabbitmq.client.Channel;
import rabbitmq.util.RabbitMqUtils;

/**
 * @author ： CodeWater
 * @create ：2022-06-09-17:50
 * @Function Description ：演示死信场景
 * 生产者：只需要要关联正常的交换机、队列即可
 * 
 * 首先把生产者和消费者1启动，然后关闭消费者1，再运行生产者1，死信队列中就会有数据。
 * 这个时候就需要消费者2来消费死信队列中的数据，启动2.
 */
public class Producer {
    public static final String NORMAL__EXCHANGE = "normal_exchange";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        //设置消息的 TTL 时间   ms
//        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder().expiration("100000").build();
        for( int i = 1 ; i < 11 ; i++ ){
            String message = "info" + i;
//            channel.basicPublish( NORMAL__EXCHANGE , "zhangsan" , properties , message.getBytes() );
            
            //设置队列的最大长度
            channel.basicPublish( NORMAL__EXCHANGE , "zhangsan" , null , message.getBytes() );
            
        }
    }
}
