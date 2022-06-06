package rabbitmq.three;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import rabbitmq.util.RabbitMqUtils;
import rabbitmq.util.SleepUtils;

/**
 * @author ： CodeWater
 * @create ：2022-06-06-0:21
 * @Function Description ：消费者
 * 演示： 消息在手动应答时是不丢失，放回队列中重新消费
 * rabbitmq默认是轮询分发，需要设置1才能是不公平分发，需要在消费者出设置
 */
public class Work03 {
    public static final String TASK_QUEUE_NAME = "ack_queue";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        System.out.println( "C1等待接受消息处理时间较短。。。");

        //执行的消息
        DeliverCallback deliverCallback = (consumerTag , message ) -> {
            SleepUtils.sleep( 1);

            System.out.println("接收到的消息" + new String( message.getBody() , "utf-8") );
            
            //设置不公平分发1;默认分发是轮询0;预取值设置2，队列中能够最多放2条
            int prefetchCount = 2;
            channel.basicQos( prefetchCount );
            
            /**手动应答逻辑
             * *1.消息的标记tag
             * *2.是否批量应答false:不批量应答信道中的消息true:批量
             */
            channel.basicAck( message.getEnvelope().getDeliveryTag() , false );
        };
        
        boolean autoAck = false;
        channel.basicConsume( TASK_QUEUE_NAME , autoAck , deliverCallback ,  (consumerTag) -> {
            System.out.println( "消费者取消消费接口回调逻辑。。" );
        });
    }
}
