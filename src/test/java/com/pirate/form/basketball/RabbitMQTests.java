package com.pirate.form.basketball;

import com.pirate.form.basketball.dao.MessagePO;
import com.pirate.form.basketball.queue.producer.RabbitSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTests {

    @Autowired
    private RabbitSender rabbitSender;

    @Test
    public void rabbitSenderTest() throws Exception {
        MessagePO message = new MessagePO(1, "无敌海贼", UUID.randomUUID().toString());
        rabbitSender.sendMessage(message);

        MessagePO message2 = new MessagePO(2, "黑胡子", UUID.randomUUID().toString());
        rabbitSender.sendMessage2Queue(RabbitSender.DEFAULT_QUEUE, message2);
    }
}
