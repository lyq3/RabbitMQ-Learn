package com.lyq3.rabbit.exchange;

import com.rabbitmq.client.*;
import java.io.IOException;
/**
 * 日志消费者
 * @author 卡卢比
 */
public class ReceiveLogs {
    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] argv) throws Exception {
        //建立连接和通道
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("112.74.57.197");
        factory.setUsername("lyq");
        factory.setPassword("92932266");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        //声明路由器及类型
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
        //声明一个随机名字的队列
        String queueName = channel.queueDeclare().getQueue();
        //绑定队列到路由器上
        channel.queueBind(queueName, EXCHANGE_NAME, "");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        //开始监听消息
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received==消费者1==\n '" + message + "'");
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }
}
