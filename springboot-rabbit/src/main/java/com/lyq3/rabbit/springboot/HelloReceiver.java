package com.lyq3.rabbit.springboot;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "springbootMQ")
public class HelloReceiver {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("接收  : " + hello);
    }

}
