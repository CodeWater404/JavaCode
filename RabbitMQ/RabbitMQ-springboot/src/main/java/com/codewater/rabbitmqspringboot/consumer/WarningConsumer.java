package com.codewater.rabbitmqspringboot.consumer;

import com.codewater.rabbitmqspringboot.config.ConfirmConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author ： CodeWater
 * @create ：2022-06-11-21:04
 * @Function Description ：
 * 报警消费者
 */
@Slf4j
@Component
public class WarningConsumer {
    
    //接受报警消息
    @RabbitListener( queues = ConfirmConfig.WARNING_QUEUE_NAME )
    public void receiveWarningMsg( Message message ){
        String msg = new String( message.getBody() );
        log.error("报警发现不可路由消息：{} " , msg );
    }
}
