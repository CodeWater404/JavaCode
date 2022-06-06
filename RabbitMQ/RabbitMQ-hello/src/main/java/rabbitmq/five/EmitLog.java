package rabbitmq.five;

import com.rabbitmq.client.Channel;
import rabbitmq.util.RabbitMqUtils;

import java.util.Scanner;

/**
 * @author ： CodeWater
 * @create ：2022-06-06-19:35
 * @Function Description ：fanout演示：是将接收到的所有消息广播到它知道的所有队列中
 * 发消息 交换机
 */
public class EmitLog {
    //交换机的名称
    public static final String EXCHANGE_NAME = "logs";
    
    public static void main( String[] args ) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        channel.exchangeDeclare( EXCHANGE_NAME , "fanout" );
        
        Scanner sc = new Scanner( System.in );
        
        while( sc.hasNext() ){
            String message = sc.next();
            channel.basicPublish( EXCHANGE_NAME , "" , null , message.getBytes("utf-8") );
            System.out.println( "生产者发出消息： " + message );
        }
        
    }
}
