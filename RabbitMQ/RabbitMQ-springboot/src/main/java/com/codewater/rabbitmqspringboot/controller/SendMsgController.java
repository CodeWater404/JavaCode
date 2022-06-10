package com.codewater.rabbitmqspringboot.controller;

import com.codewater.rabbitmqspringboot.config.DelayQueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author ： CodeWater
 * @create ：2022-06-10-17:28
 * @Function Description ：
 * 
 * 发送延迟消息
 * 这里相当于生产者了，通过网页去发送给mq消息
 */
@Slf4j
@RestController
@RequestMapping("/ttl/")
public class SendMsgController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 开始发消息: 用网页去访问发，不要写mq的端口：localhost:8080/ttl/sendMsg/嘻嘻嘻
     * @param msg
     */
    @GetMapping("/sendMsg/{msg}")
    public void sendMsg( @PathVariable String msg ){
        log.info( "当前时间:{},发送一条消息给两个TTL队列:{}" , new Date() , msg );
        rabbitTemplate.convertAndSend( "X" , "XA" , "消息来自ttl为10s的队列" + msg);
        rabbitTemplate.convertAndSend( "X" , "XB" , "消息来自ttl为40s的队列" + msg);
    }

    /**
     * 开始发消息，访问地址：http://localhost:8080/ttl/sendExpiration/nihaonihao/2
     * @param message 消息的内容
     * @param ttlTime 延迟时长
     */
    @GetMapping("/sendExpiration/{message}/{ttlTime}")
    public void sendMsg(@PathVariable String message , @PathVariable String ttlTime ){
        log.info( "当前时间：{} ， 发送一条时长{}毫秒ttl信息给队列qc：{} " , 
                new Date().toString() , ttlTime , message );
        rabbitTemplate.convertAndSend( "X" , "XC" , message , msg -> {
            //发送消息的时候， 延迟时长
            msg.getMessageProperties().setExpiration(ttlTime);
            return msg;
        });
    }
    
    //开始发消息  基于插件的消息 及 延迟的时间
    @GetMapping("/sendDelayMsg/{message}/{delayTime}")
    public void sendMsg(@PathVariable String message , @PathVariable Integer delayTime ){
        log.info("当前时间：{} ， 发送一条延迟{}毫秒的信息给队列：delayed.queue:{}" , new Date() ,
                delayTime , message );
        
        rabbitTemplate.convertAndSend(DelayQueueConfig.DELAYED_EXCHANGE_NAME , 
                DelayQueueConfig.DELAYED_ROUTING_KEY,
                message , msg -> {
            //发送消息的时候延迟时长  ms
                    msg.getMessageProperties().setDelay( delayTime );
                    return msg;
                });
        
    }
    
}
