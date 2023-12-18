package com.rabbitmq.rabbitlistenerproject;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQQueueConfiguration {

    @Bean
    Queue myQueue1st() {
        return new Queue("ExampleQueue3", true);
    }

    @Bean
    Queue myQueue2nd() {
        return QueueBuilder.durable("ExampleQueue4")
                .autoDelete()
                .build();
    }
    
}
