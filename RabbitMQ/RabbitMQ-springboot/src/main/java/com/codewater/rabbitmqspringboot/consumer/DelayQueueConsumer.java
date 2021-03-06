package com.codewater.rabbitmqspringboot.consumer;

import com.codewater.rabbitmqspringboot.config.DelayedQueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ： CodeWater
 * @create ：2022-06-10-23:13
 * @Function Description ：
 * 消费者 基于插件的延迟消息
 * 
 */
@Component
@Slf4j
public class DelayQueueConsumer {
    
    //监听消息
    @RabbitListener( queues = DelayedQueueConfig.DELAYED_QUEUE_NAME )
//    @RabbitListener( queues = "delayed.queue" )
    public void receiveDelayQueue( Message message ){
        String msg = new String( message.getBody() );
        log.info( "当前时间：{} ， 收到延迟队列的消息：{} "  , new Date().toString() , msg );
    }
    
    
}
