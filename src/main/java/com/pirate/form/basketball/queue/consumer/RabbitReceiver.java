package com.pirate.form.basketball.queue.consumer;

import com.alibaba.fastjson.JSON;
import com.pirate.form.basketball.dao.MessagePO;
import com.pirate.form.basketball.queue.producer.RabbitSender;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class RabbitReceiver {

//    @RabbitHandler
//    public void onMessage(Message message, Channel channel) throws Exception {
//        String string = message.toString();
//        System.out.println("------------------  收到消息: " + string);
//        //ACK 手动签收
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//    }

    @RabbitListener(queues = RabbitSender.DEFAULT_QUEUE)
    public void onMessage(@Payload MessagePO messagePO, Message message, Channel channel) throws Exception {
        System.err.println("------------------  收到消息: " + JSON.toJSONString(messagePO));
        //ACK 手动签收
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
