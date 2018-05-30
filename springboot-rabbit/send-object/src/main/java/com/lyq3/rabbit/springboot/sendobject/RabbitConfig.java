package com.lyq3.rabbit.springboot.sendobject;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    @Bean
    public Queue Queue() {
        return new Queue("springbootMQ");
    }

}