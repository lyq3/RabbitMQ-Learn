package com.lyq3.rabbit.taskwork;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * 创建任务
 */
public class NewTask {
    //队列名字
    private final static String QUEUE_NAME = "helloworld";

    public static void main(String[] argr)throws Exception {

        //创建通道
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("112.74.57.197");
        factory.setUsername("lyq");
        factory.setPassword("92932266");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //为通道指明队列
        boolean durable = true;//持久化队列
        channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
        //发布消息
        //那么如何将消息持久化呢：将MessageProperties的值设置为PERSISTENT_TEXT_PLAIN。
        for (int i=0;i<10000;i++) {
            channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, (i+"...").getBytes());
            System.out.println(" [x] Sent '" + i + "'");
        }

        //关闭连接
        channel.close();
        connection.close();
    }
}
