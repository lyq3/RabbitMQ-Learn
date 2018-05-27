package com.lyq3.rabbit.topic;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * 日志消费者一
 * @author 卡卢比
 */
public class ReceiveLogsTopic2 {

    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] argv) throws Exception {
        //建立连接和通道
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("112.74.57.197");
        factory.setUsername("lyq");
        factory.setPassword("92932266");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        //声明路由器和路由器类型
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        String queueName = channel.queueDeclare().getQueue();

        String bingingKeys[] = {"*.critical"};

        for (String bindingKey : bingingKeys) {
            channel.queueBind(queueName, EXCHANGE_NAME, bindingKey);
        }

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        //监听消息
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '===消费者2：\n" + envelope.getRoutingKey() + "':'" + message + "'");
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }
}
