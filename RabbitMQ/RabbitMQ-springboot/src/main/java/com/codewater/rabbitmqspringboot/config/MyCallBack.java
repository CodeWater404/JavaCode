package com.codewater.rabbitmqspringboot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author ： CodeWater
 * @create ：2022-06-11-15:59
 * @Function Description ：
 * 回调接口
 */
@Slf4j
@Component
public class MyCallBack implements RabbitTemplate.ConfirmCallback , RabbitTemplate.ReturnsCallback{

    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    /**
     * 把mycallback注入到RabbitTemplate类中，这样用RabbitTemplate才能正确调用重写后的ConfirmCallback
     * 用这个注解相当于注入，才会真正执行，在声明RabbitTemplate类之后才会执行
     */
    @PostConstruct  
    public void init(){
        rabbitTemplate.setConfirmCallback( this ) ;
        rabbitTemplate.setReturnsCallback( this );
    }
    
    /**
     * 水交换机确认回调方法
     * 1.发消息交换机接收到了回调
     *  1.1correlationData保存回调消息的ID及相关信息(需要在发送方进行声明初始化)
     *  1.2交换机收到消息ack =true
     *  1.3cause null
     * 2.发消息交换机接收失败了回调
     *  2.1correlationDaxa 保存回调消息的ID及相关信息
     *  2.2交换机收到消息ack=false
     *  2.3cause 失败原因
     */
    @Override
    public void confirm(CorrelationData correlationData , boolean ack , String cause ){
        String id = correlationData != null ? correlationData.getId() : "";
        if( ack ){
            log.info("交换机已经收到id为：{} 的消息 " , id );
        }else{
            log.info("交换机还未收到id为：{} 的消息 ， 由于原因：{} " , id , cause );
        }
    }
    
    /**
     * 可以在当消息传递过程中不可达目的地时将消息返回给生产者
     *      只有不可达目的地的时候才进行回退
     * 该方法过时了，看的尚硅谷，必须要重写下面一种方法才能正确回调失败的信息
     * @param returnedMessage
     */
//    @Override 
//    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
//        log.error("消息：{} ， 被交换机：{} 退回 。 退回原因：{} ， 路由key：{} " ,
//                new String(message.getBody()) , exchange , replyText , routingKey );
//    }

    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {
        log.error("消息{}，被交换机{}退回，退回的原因是：{}，路由routingkey是：{}",new String(returnedMessage.getMessage().getBody()),returnedMessage.getExchange(),
                returnedMessage.getReplyText(),returnedMessage.getRoutingKey());
    }

}
