package com.lyq3.rabbit.springboot.object;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * 接受者
 * @author 卡卢比
 */
public class Receiver {
    @RabbitListener(queues = "springbootMQ")
    @RabbitHandler
    public void process(User user){
        System.out.println("====接收====\n"+user);
    }
}
