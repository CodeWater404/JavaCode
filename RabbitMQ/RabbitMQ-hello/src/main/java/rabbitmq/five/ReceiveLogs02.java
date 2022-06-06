package rabbitmq.five;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import rabbitmq.util.RabbitMqUtils;

/**
 * @author ： CodeWater
 * @create ：2022-06-06-19:24
 * @Function Description ：fanout演示：是将接收到的所有消息广播到它知道的所有队列中
 * 消息接收
 */
public class ReceiveLogs02 {
    //交换机的名称
    public static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        //声明一个临时队列
        /*生成一个临时队列、队列的名称是随机的
           当消费者断开与队列的连接的时候队列就自动删除
        * */
        String queueName = channel.queueDeclare().getQueue();

        /*绑定交换机与队列*/
        channel.queueBind( queueName , EXCHANGE_NAME , "" );
        System.out.println( "等待接收消息， 把接收到消息打印在屏幕上。。。。。");

        //接收消息
        DeliverCallback deliverCallback = (consumerTag , message ) ->{
            System.out.println( "222控制台打印接收到的消息： " + new String( message.getBody() , "utf-8") );
        };

        //消费者取消消息时回调接口
        channel.basicConsume( queueName , true , deliverCallback , consumerTag -> {} );

    }
}
