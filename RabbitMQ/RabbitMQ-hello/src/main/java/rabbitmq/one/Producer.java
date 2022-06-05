package rabbitmq.one;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author ： CodeWater
 * @create ：2022-06-05-20:59
 * @Function Description ：生产者
 * 发消息
 */

public class Producer {
    
    //队列名称
    public static final String QUEUE_NAME = "hello";
    
    //发消息
    public static void main(String[] args) throws Exception  {
        
        //创建一个连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.91.130");
        factory.setUsername( "root" );
        factory.setPassword( "root" );
        //创建一个连接
        Connection connection = factory.newConnection();
        //获取信道
        Channel channel = connection.createChannel();
        /**
         * 生成一个队列方法参数解释：
         * 1.队列名称
         * 2.队列里面的消息是否持久化 默认消息存储在内存中
         * 3.该队列是否只供一个消费者进行消费 是否进行共享 true 可以多个消费者消费
         * 4.是否自动删除 最后一个消费者端开连接以后 该队列是否自动删除 true 自动删除
         * 5.其他参数
         */
        channel.queueDeclare( QUEUE_NAME , false , false , false , null );
        
        //发消息的内容
        String message = "hello world";

        /**
         * 发送一个消息方法参数解释：
         * 1.发送到那个交换机
         * 2.路由的 key 是哪个
         * 3.其他的参数信息
         * 4.发送消息的消息体
         */
        channel.basicPublish( "" , QUEUE_NAME , null , message.getBytes() );

        System.out.println( "消息发送完毕！！！！！" );

    }
    
}
