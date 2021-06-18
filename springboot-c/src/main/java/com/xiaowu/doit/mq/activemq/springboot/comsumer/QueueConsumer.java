package com.xiaowu.doit.mq.activemq.springboot.comsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.TextMessage;

@Component
public class QueueConsumer {
    @Autowired
    private JmsMessagingTemplate template;

    @JmsListener(destination = "${myqueue}")
    public void receiveQueueMsg(TextMessage textMessage) throws Exception{
        System.out.println("**********springboot receive queue msg : " + textMessage.getText());
    }

    @JmsListener(destination = "${mytopic}")
    public void receiveTopicMsg(TextMessage textMessage) throws Exception{
        System.out.println("**********springboot receive topic msg : " + textMessage.getText());
    }
}
