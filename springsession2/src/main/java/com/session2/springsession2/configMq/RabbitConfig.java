package com.session2.springsession2.configMq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * Created by LeuMu Zhao on 2021/3/23 0023 21:56
 */
@Configuration
public class RabbitConfig {
    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.virtual-host}")
    private String virtualHost;

    public static final String EXCHANGE_A = "my-mq-direct_exchange";
    public static final String EXCHANGE_B = "my-mq-exchange_B";
    public static final String EXCHANGE_C = "my-mq-exchange_C";
    public static final String EXCHANGE_D = "my-mq-exchange_D";


    public static final String QUEUE_A = "QUEUE_A";
    public static final String QUEUE_A_FAIL = "QUEUE_A_FAIL";
    public static final String QUEUE_B = "QUEUE_B";
    public static final String QUEUE_D = "QUEUE_D";

    public static final String ROUTINGKEY_A = "spring-boot-routingKey_A";
    public static final String ROUTINGKEY_A_FAIL = "spring-boot-routingKey_A_FAIL";
    public static final String ROUTINGKEY_B = "spring-boot-routingKey_B";
    public static final String ROUTINGKEY_D = "spring-boot-routingKey_D";

    //建立一个连接容器，类型数据库的连接池
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host,port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualHost);
        connectionFactory.setPublisherConfirms(true);//确认机制
//        connectionFactory.setPublisherReturns(true);
        //发布确认，template要求CachingConnectionFactory的publisherConfirms属性设置为true
        return connectionFactory;
    }

    //RabbitMQ的使用入口
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    //必须是prototype类型
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(this.connectionFactory());
        template.setMessageConverter(this.jsonMessageConverter());
        template.setMandatory(true);
        return template;
    }


    //把交换机，队列，通过路由关键字进行绑定，写在RabbitConfig类当中
    /**
     * 针对消费者配置
     * 1. 设置交换机类型
     * 2. 将队列绑定到交换机
     FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
     HeadersExchange ：通过添加属性key-value匹配
     DirectExchange:按照routingkey分发到指定队列
     TopicExchange:多关键字匹配
     */
    @Bean
    public DirectExchange testDirectExchange() {
        return new DirectExchange(EXCHANGE_A);
    }
    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(EXCHANGE_B);
    }
    @Bean
    public DirectExchange testDemoExchange() {
        return new DirectExchange(EXCHANGE_D);
    }

    /**
     * 获取队列A
     * durable:是否持久化,默认是false,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
     * exclusive:默认也是false，只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable
     * autoDelete:是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除。
     * return new Queue("TestDirectQueue",true,true,false);
     * 一般设置一下队列的持久化就好,其余两个就是默认false
     * @return
     */
    @Bean
    public Queue queueA() {
        return new Queue(QUEUE_A, true); //队列持久
    }

    @Bean
    public Queue queueAFail(){
        return new Queue(QUEUE_A_FAIL, true);//队列持久
    }

    //将队列和交换机绑定, 并设置用于匹配键：spring-boot-routingKey_A
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queueA()).to(testDirectExchange()).with(ROUTINGKEY_A);
    }

    @Bean
    public Binding bindingAFail() {
        return BindingBuilder.bind(queueAFail()).to(testDirectExchange()).with(RabbitConfig.ROUTINGKEY_A_FAIL);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    //一个交换机可以绑定多个消息队列，也就是消息通过一个交换机，可以分发到不同的队列当中去。
    /**
     * 获取队列B
     * @return
     */
    @Bean
    public Queue queueB() {
        return new Queue(QUEUE_B, true); //队列持久
    }

    @Bean
    public Binding bindingB(){
        return BindingBuilder.bind(queueB()).to(defaultExchange()).with(ROUTINGKEY_B);
    }

    /**
     * 获取队列D
     * @return
     */
    @Bean
    public Queue queueD() {
        return new Queue(QUEUE_B, true); //队列持久
    }

    @Bean
    public Binding bindingD(){
        return BindingBuilder.bind(queueB()).to(testDemoExchange()).with(ROUTINGKEY_B);
    }

    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }
}
