package rabbitmq.six;

import com.rabbitmq.client.Channel;
import rabbitmq.util.RabbitMqUtils;

import java.util.Scanner;

/**
 * @author ： CodeWater
 * @create ：2022-06-07-21:40
 * @Function Description ：Direct exchange演示：指定发给哪个队列（但是不能同时发给多个队列）
 * 生产者
 * 
 */
public class DirectLogs {
    public static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args)  throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        Scanner sc = new Scanner( System.in );
        
        while( sc.hasNext() ){
            String message = sc.next();
//            这里routingKey指定不同的队列名，就会往不同的队列发出
            channel.basicPublish( EXCHANGE_NAME , "error" , null, message.getBytes("utf-8" ) );
            System.out.println("生产者发出消息： " + message );
        }
    }
}
