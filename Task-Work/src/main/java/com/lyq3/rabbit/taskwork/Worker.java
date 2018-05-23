package com.lyq3.rabbit.taskwork;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * 任务执行者
 */
public class Worker {
    //队列名字
    private final static String QUEUE_NAME = "helloworld";

    public static void main(String[] argr)throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("112.74.57.197");
        factory.setUsername("lyq");
        factory.setPassword("92932266");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        //声明要消费的队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        //回调消费消息
        int prefetchCount = 1;
        channel.basicQos(prefetchCount);//Rabbit默认轮流平均地发消息，为了改变这种情况，我们可以使用basicQos方法，并将参数prefetchCount设为1。这样做，工作者就会告诉RabbitMQ：不要同时发送多个消息给我，每次只发1个，当我处理完这个消息并给你确认信息后，你再发给我下一个消息。这时候，RabbitMQ就不会轮流平均发送消息了，而是寻找闲着的工作者。
        final Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");

                System.out.println(" [x] Received '" + message + "'");
                try {
                    doWork(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(" [x] Done");
                }
            }
        };
        boolean autoAck = true; // true:关闭消息确认，false开启消息确认（默认）
        channel.basicConsume(QUEUE_NAME, autoAck, consumer);
    }

    private static void doWork(String task) throws InterruptedException {
        //模拟任务执行
        System.out.println("开始执行");
        for (char ch: task.toCharArray()) {
            if (ch == '.') Thread.sleep(1000);
        }
    }
}
