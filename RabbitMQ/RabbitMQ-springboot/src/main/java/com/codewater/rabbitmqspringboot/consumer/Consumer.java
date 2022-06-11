package com.codewater.rabbitmqspringboot.consumer;

import com.codewater.rabbitmqspringboot.config.ConfirmConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author ： CodeWater
 * @create ：2022-06-11-15:45
 * @Function Description ：
 * 接收ProducerController发送消息的
 * 
 */
@Slf4j
@Component
public class Consumer {
    
    @RabbitListener( queues = ConfirmConfig.CONFIRM_QUEUE_NAME )
    public void receiveConfirmMessage( Message message ){
        String msg =  new String( message.getBody() );
        log.info("接收到的队列消息： {}  "  , msg );
    }
    
    
}
