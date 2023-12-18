package com.rabbitmq.rabbitlistenerproject;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.util.Date;

public class RabbitMQMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("Mensagem processada " + new Date() + new String(message.getBody()));
    }
}
