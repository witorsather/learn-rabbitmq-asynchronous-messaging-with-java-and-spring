package com.rabbitmq.rabbitlistenerproject;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQExchangeConfiguration {
    @Bean
    Exchange myExchange1st() {
        return new TopicExchange("ExampleExchangeNew");
    }

    @Bean
    Exchange myExchange2nd() {
        return ExchangeBuilder.topicExchange("ExampleTopicExchangeBuilder")
                .autoDelete()
                .internal()
                .build();
    }

    @Bean
    Exchange myExchange3rd() {
        return ExchangeBuilder.topicExchange("TopicTestExchange")
                .durable(false)
                .internal()
                .autoDelete()
                .build();
    }

    @Bean
    Exchange fannoutExchange() {
        return ExchangeBuilder.fanoutExchange("FannoutExchange")
                .durable(true)
                .autoDelete()
                .internal()
                .build();
    }

    @Bean
    Exchange headersExchange () {
        return ExchangeBuilder.headersExchange("HeaderExchange")
                .internal()
                .durable(true)
                .autoDelete()
                .ignoreDeclarationExceptions()
                .build();
    }
}
