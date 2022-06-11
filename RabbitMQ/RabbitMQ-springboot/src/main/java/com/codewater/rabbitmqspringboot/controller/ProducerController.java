package com.codewater.rabbitmqspringboot.controller;

import com.codewater.rabbitmqspringboot.config.ConfirmConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ： CodeWater
 * @create ：2022-06-11-15:38
 * @Function Description ：
 * 开始发消息 测试确认
 * 也就是发送方发消息，看交换机或者队列有没有收到消息；没有收到该怎么办，收到消息该怎么办
 *          1. 回退给生产者，回调
 *          2. 配置备份交换机
 *          （两个都配置了， 会优先使用备份交换机）
 * 补充知识：@GetMapping相当于@RequestMapping(method = RequestMethod.GET)
 */
@Slf4j
@RestController
@RequestMapping("/confirm")
public class ProducerController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    //正常发消息
    @GetMapping("/sendMessage/{message}")
    public void sendMessage(@PathVariable String message ){
        CorrelationData correlationData = new CorrelationData("1"); 
        //可以成功发送的
//        rabbitTemplate.convertAndSend(ConfirmConfig.CONFIRM_EXCHANGE_NAME , 
//                ConfirmConfig.CONFIRM_ROUTING_KEY , message  , correlationData );

        //不能成功发送的 -----交换机错误----会有错误提示，原因----实现ConfirmCallback接口
//        rabbitTemplate.convertAndSend(ConfirmConfig.CONFIRM_EXCHANGE_NAME + "123",
//                ConfirmConfig.CONFIRM_ROUTING_KEY , message  , correlationData );

        //不能成功发送的 -----队列错误----没有错误提示，原因(需要在配置文件中开启配置，然后实现ReturnCallback接口)
        rabbitTemplate.convertAndSend(ConfirmConfig.CONFIRM_EXCHANGE_NAME ,
                ConfirmConfig.CONFIRM_ROUTING_KEY + "123", message  , correlationData );
        
        log.info("发送的消息内容：{}"  , message );
    }
    
    
}
