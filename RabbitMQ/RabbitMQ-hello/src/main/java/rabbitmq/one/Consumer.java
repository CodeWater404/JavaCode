package rabbitmq.one;

import com.rabbitmq.client.*;

/**
 * @author ： CodeWater
 * @create ：2022-06-05-21:38
 * @Function Description ：消费者
 * 接受消息
 */
public class Consumer {
    //队列的名称
    public static final String QUEUE_NAME = "hello" ;
    
    //接受消息
    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost( "192.168.91.130" );
        factory.setUsername("root");
        factory.setPassword("root");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        //声明 接受消息
        DeliverCallback deliverCallback = ( consumerTag , message) -> {
            System.out.println( new String(message.getBody()) );
        };
        
        //取消消费的一个回调接口 如在消费的时候队列被删除掉了
        CancelCallback cancelCallback = consumerTag -> {
            System.out.println( "消费消息被终端" );
        };
        
        /**
         * 消费者消费消息方法参数解释：
         * 1.消费哪个队列
         * 2.消费成功之后是否要自动应答 true 代表自动应答 false 手动应答
         * 3.消费者未成功消费的回调
         */
        channel.basicConsume( QUEUE_NAME , true , deliverCallback , cancelCallback );
        
    }
    
}
