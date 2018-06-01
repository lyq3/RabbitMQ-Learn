package com.lyq3.springboot.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接受者
 * @author 卡卢比
 */
@Component
public class Receiver {
    @RabbitListener(queues="topic.message")
    @RabbitHandler
    public void process1(User user){
        System.out.println("====消费者1接收====\n"+user);
    }

    @RabbitListener(queues="topic.messages")
    @RabbitHandler
    public void process2(User user){
        System.out.println("====消费者2接收====\n"+user);
    }
}
