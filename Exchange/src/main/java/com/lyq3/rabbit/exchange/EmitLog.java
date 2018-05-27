package com.lyq3.rabbit.exchange;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

/**
 * 日志生产者
 * 注，生产者一般不关心消息发给哪个队列，一般发给交换器，交换器再路由
 */
public class EmitLog {
    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] argv) throws Exception {
        //建立连接和通道
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("112.74.57.197");
        factory.setUsername("lyq");
        factory.setPassword("92932266");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        //声明路由以及路由的类型
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);

        String message = "msg...";

        //发布消息
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
        System.out.println(" [x] Sent '" + message + "'");

        //关闭连接和通道
        channel.close();
        connection.close();
    }
}
