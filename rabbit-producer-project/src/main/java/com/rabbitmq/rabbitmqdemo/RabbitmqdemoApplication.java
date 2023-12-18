package com.rabbitmq.rabbitmqdemo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class RabbitmqdemoApplication implements CommandLineRunner {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqdemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        vai para exchange padrao amqp default
//        rabbitTemplate.convertAndSend("Hello, this is my first message");

//        vai para a exchange TestExchange e a fila RoutedQueue que tem a chave de roteamento testRouting com mensagem de texto
//        rabbitTemplate.convertAndSend("TestExchange", "testRouting", "Hello, this is my first message to RoutedQueue");

//        vai para a exchange TestExchange e a fila RoutedQueue que tem a chave de roteamento testRouting com objeto como mensagem
//        SimpleMessage simpleMessage = new SimpleMessage();
//        simpleMessage.setName("SimpleName");
//        simpleMessage.setDescription("SimpleDescription");
//        rabbitTemplate.convertAndSend("TestExchange", "testRouting", simpleMessage);

//        vai topic MyTopicExchange MyRoutingKey para MyQueue
        for (int i = 1; i > 0; i++) {
            Thread.sleep(20000);
            SimpleMessage simpleMessage = new SimpleMessage();
            simpleMessage.setName("Simple message " + i + ", ");
            simpleMessage.setDescription("Simple Description " + i);
            System.out.println(i + " - " + new Date() + " - enviada message = " + simpleMessage);
            rabbitTemplate.convertAndSend("MyTopicExchange", "MyRoutingKey", simpleMessage);
        }
    }
}
