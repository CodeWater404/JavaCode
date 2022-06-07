package rabbitmq.seven;

import com.rabbitmq.client.Channel;
import rabbitmq.util.RabbitMqUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ： CodeWater
 * @create ：2022-06-07-22:51
 * @Function Description ：topic模式演示：可以指定发送给特定的某个或者某些队列（fanout是全部，direct是某个，不能多个）
 * 生产者
 */
public class EmitLogTopic {
    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args)  throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        channel.exchangeDeclare( EXCHANGE_NAME , "topic" );
        /** * Q1-->绑定的是
         * * 中间带orange带3个单词的字符串(*.orange.*)
         * * Q2-->绑定的是
         * * 最后一个单词是rabbit的3个单词(*.*.rabbit)
         * * 第一个单词是lazy的多个单词(lazy.#) * */
        Map<String , String> bindingKeyMap = new HashMap<>();
        bindingKeyMap.put("quick.orange.rabbit", "被队列Q1Q2接收到");
        bindingKeyMap.put("lazy.orange.elephant", "被队列Q1Q2接收到");
        bindingKeyMap.put("quick.orange.fox", "被队列Q1接收到");
        bindingKeyMap.put("lazy.brown.fox", "被队列Q2接收到");
        bindingKeyMap.put("lazy.pink.rabbit", "虽然满足两个绑定但只被队列Q2接收一次");
        bindingKeyMap.put("quick.brown.fox", "不匹配任何绑定不会被任何队列接收到会被丢弃");
        bindingKeyMap.put("quick.orange.male.rabbit", "是四个单词不匹配任何绑定会被丢弃");
        bindingKeyMap.put("lazy.orange.male.rabbit", "是四个单词但匹配Q2");
        for( Map.Entry<String , String> bindingKeyEntry : bindingKeyMap.entrySet() ){
            String bindingKey = bindingKeyEntry.getKey();
            String message = bindingKeyEntry.getValue();
            channel.basicPublish( EXCHANGE_NAME , bindingKey , null , message.getBytes("utf-8" ) );
            
            System.out.println( "生产者发出消息" + message );
        }
    }
}
