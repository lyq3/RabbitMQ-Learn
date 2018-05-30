package com.lyq3.rabbit.springboot.sendobject.object;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 发送者
 * @author 卡卢比
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendObject(User user){
        System.out.println("=====发送=====\n");
        this.rabbitTemplate.convertAndSend("springbootMQ", user);
    }
}
