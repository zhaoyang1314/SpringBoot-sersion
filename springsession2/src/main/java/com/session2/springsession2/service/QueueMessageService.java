package com.session2.springsession2.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * Created by LeuMu Zhao on 2021/3/23 0023 22:02
 */
public interface QueueMessageService extends RabbitTemplate.ConfirmCallback  {
    /**
     * 发送消息到rabbitmq消息队列
     * @param message 消息内容
     * @param exchange 交换配置
     * @param queueRoutingKey routingKey的队列
     * @throws Exception
     */
    void send(Object message, String exchange, String queueRoutingKey) throws Exception;

}
