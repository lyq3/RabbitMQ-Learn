package com.lyq3.rabbit.springboot.sendobject.object;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接受者
 * @author 卡卢比
 */
@RabbitListener(queues = "springbootMQ")
@Component
public class Receiver {
    @RabbitHandler
    public void process(User user){
        System.out.println("====接收====\n"+user);
    }
}
