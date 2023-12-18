package com.rabbitmq.rabbitmqdemo;


import java.io.Serializable;

public class SimpleMessage implements Serializable {
    private String name;
    private String description;

    public SimpleMessage() {}

    public SimpleMessage(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "Mensagem = " + this.name + "description " + this.description;
    }
    
}
