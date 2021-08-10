package com.session2.springsession2.service.impl;

import com.session2.springsession2.service.QueueMessageService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

/**
 * Created by LeuMu Zhao on 2021/3/23 0023 22:05
 */
@Service
public class QueueMessageServiceImpl implements QueueMessageService {
    //由于配置类RabbitMqConfig配置类中的rabbitTemplate的scope属性设置为ConfigurableBeanFactory.SCOPE_PROTOTYPE
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public QueueMessageServiceImpl(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
        //设置回调为当前类对象
        rabbitTemplate.setConfirmCallback(this);
    }
    @Override
    public void send(Object message, String exchange, String queueRoutingKey) throws Exception {
        //构建回调id为uuid
        String callBackId = UUID.randomUUID().toString();
        CorrelationData correlationId = new CorrelationData(callBackId);
        System.out.println("开始发送消息内容:{}"+message.toString());
        //发送消息到消息队列
        rabbitTemplate.convertAndSend(exchange, queueRoutingKey, message, correlationId);
        System.out.println("发送定制的回调id:{}"+callBackId);
    }


    /**
     * 消息回调确认方法
     * @param correlationData 请求数据对象
     * @param b 是否发送成功
     * @param s
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        System.out.println(" 回调id:" + correlationData.getId());
        if (b) {
            System.out.println("消息发送成功");
        } else {
            System.out.println("消息发送失败:" + s);
        }
    }
}
