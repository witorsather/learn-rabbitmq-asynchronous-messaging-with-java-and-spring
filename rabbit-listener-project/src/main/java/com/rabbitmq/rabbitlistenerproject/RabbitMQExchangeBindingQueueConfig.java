package com.rabbitmq.rabbitlistenerproject;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQExchangeBindingQueueConfig {
    private static final String MY_QUEUE = "MyQueue";
    private static final String MY_EXCHANGE = "MyTopicExchange";
    private static final String MY_ROUTING_KEY = "MyRoutingKey";

    @Bean
    Queue myQueue() {
        return new Queue(MY_QUEUE, true);
    }

    @Bean
    Exchange myExchange() {
        return ExchangeBuilder.topicExchange(MY_EXCHANGE)
                .durable(true)
                .build();
    }

    @Bean
    Binding myBinding() {
        return new Binding(MY_QUEUE, Binding.DestinationType.QUEUE, MY_EXCHANGE, MY_ROUTING_KEY, null);
//        return BindingBuilder.bind(myQueue())
//                .to(myExchange())
//                .with(MY_ROUTING_KEY)
//                .noargs();
    }

    @Bean
    ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");

        return cachingConnectionFactory;
    }

    @Bean
    MessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
        simpleMessageListenerContainer.setQueues(myQueue());
        simpleMessageListenerContainer.setMessageListener(new RabbitMQMessageListener());
        return simpleMessageListenerContainer;
    }
}
