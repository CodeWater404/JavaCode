package rabbitmq.two;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import rabbitmq.util.RabbitMqUtils;

/**
 * @author ： CodeWater
 * @create ：2022-06-05-22:03
 * @Function Description ：消费者线程
 * 演示多线程轮训接收生产者发送的消息，用idea自带的"Allow parallel run"功能启动消费者两次
 */
public class Worker01 {
    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception  {
        Channel channel = RabbitMqUtils.getChannel();
        
        //消息的接收 
        DeliverCallback deliverCallback = ( consumerTag , message ) -> {
            System.out.println( "接收到的消息：" + new String( message.getBody()) );
        };
        
        //消息接收被取消时 执行下面的内容
        CancelCallback cancelCallback = (consumerTag) -> {
            System.out.println( consumerTag + "消费者取消消费接口回调逻辑");
        };

        /**
         * 消费者消费消息方法参数解释：
         * 1.消费哪个队列
         * 2.消费成功之后是否要自动应答 true 代表自动应答 false 手动应答
         * 3.消费者未成功消费的回调
         */
        System.out.println("C2等待接受消息。。。。。。。。。");
        channel.basicConsume( QUEUE_NAME , true , deliverCallback , cancelCallback );
    }
}
