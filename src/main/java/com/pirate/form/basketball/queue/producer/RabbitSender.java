package com.pirate.form.basketball.queue.producer;

import com.pirate.form.basketball.dao.MessagePO;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitSender {
    public static final String DEFAULT_EXCHANGE = "fyn_exchange";
    public static final String DEFAULT_ROUTING_KEY = "fyn_routing";
    public static final String DEFAULT_QUEUE = "fyn_queue";

    //发送消息的模板
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(MessagePO messagePO) throws Exception {
        //可以自己指定exchange,queue等
        CorrelationData correlation = new CorrelationData();
        correlation.setId(messagePO.getMessageId());
        rabbitTemplate.convertAndSend(DEFAULT_EXCHANGE, DEFAULT_ROUTING_KEY, messagePO, correlation);
    }

    public void sendMessage2Queue(String queueName, MessagePO messagePO) throws Exception {
        rabbitTemplate.convertAndSend(queueName, messagePO);
    }

}
