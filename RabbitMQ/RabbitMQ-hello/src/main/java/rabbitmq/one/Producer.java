package rabbitmq.one;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.HashMap;
import java.util.Map;

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
        //模拟优先队列
        Map<String , Object> arguments = new HashMap<>();
        //官方允许是0-255之间  此处设置10  允许优化级范围为0-10  不要设置过大浪费CPU与内存
        arguments.put("x-max-priority" , 10 );
        channel.queueDeclare( QUEUE_NAME , true , false , false , arguments );
        
        for( int i = 0 ; i < 11 ; i++ ){
            String message = "info" + i;
            if( i == 5 ){
                //消息5设置优先级5---------在消费者这边的现象就是消息5优先消费，其余的按次序
                AMQP.BasicProperties properties = 
                        new AMQP.BasicProperties().builder().priority(5).build();
                channel.basicPublish("" , QUEUE_NAME , properties , message.getBytes() );
            }else{
                //其余消息默认优先级
                channel.basicPublish("" , QUEUE_NAME , null , message.getBytes() );
                
            }
        }
        
        //发消息的内容
        String message = "hello world";

        /**
         * 发送一个消息方法参数解释：
         * 1.发送到那个交换机
         * 2.路由的 key 是哪个
         * 3.其他的参数信息
         * 4.发送消息的消息体
         */
//        channel.basicPublish( "" , QUEUE_NAME , null , message.getBytes() );

        System.out.println( "消息发送完毕！！！！！" );

    }
    
}
