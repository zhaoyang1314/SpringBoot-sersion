package com.session.springsession.configMq;

import org.springframework.context.annotation.Configuration;

/**
 * Created by LeuMu Zhao on 2021/3/23 0023 22:34
 */
@Configuration
public class RabbitMqConfig {
    public static final String EXCHANGE_A = "my-mq-direct_exchange";
    public static final String EXCHANGE_B = "my-mq-exchange_B";
    public static final String EXCHANGE_C = "my-mq-exchange_C";


    public static final String QUEUE_A = "QUEUE_A";
    public static final String QUEUE_A_FAIL = "QUEUE_A_FAIL";
    public static final String QUEUE_B = "QUEUE_B";

    public static final String ROUTINGKEY_A = "spring-boot-routingKey_A";
    public static final String ROUTINGKEY_A_FAIL = "spring-boot-routingKey_A_FAIL";
    public static final String ROUTINGKEY_B = "spring-boot-routingKey_B";
}
