package rabbitmq.three;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import rabbitmq.util.RabbitMqUtils;
import rabbitmq.util.SleepUtils;

/**
 * @author ： CodeWater
 * @create ：2022-06-06-0:37
 * @Function Description ：消费者线程2
 * 演示： 消息在手动应答时是不丢失，放回队列中重新消费
 */
public class Work04 {
    public static final String TASK_QUEUE_NAME = "ack_queue";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
//        C2接收到消息，处理时间长，但是还没有来得及发送应答就挂了，这是C1会接收消息从而进行消费
        System.out.println( "C2等待接受消息处理时间较长。。。");

        //执行的消息
        DeliverCallback deliverCallback = (consumerTag , message ) -> {
            SleepUtils.sleep( 30 );

            System.out.println("接收到的消息" + new String( message.getBody() , "utf-8") );

            //设置不公平分发1;默认分发是轮询0;预取值设置5，队列中能够最多放5条
            int prefetchCount = 5;
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
