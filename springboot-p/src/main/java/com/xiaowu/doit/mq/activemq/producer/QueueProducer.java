package com.xiaowu.doit.mq.activemq.producer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.UUID;

@Component
@EnableJms
public class QueueProducer {
    @Autowired
    private JmsMessagingTemplate template;

    @Autowired
    private Queue queue;


    public void produceMsg(){
        template.convertAndSend(queue, "**********:" + UUID.randomUUID().toString().substring(0,6));
    }

    /**
     * 定时投放消息 --- queue
     */
    @Scheduled(fixedDelay = 3000)
    public void produceMsgScheduledQueue(){
        template.convertAndSend(queue, "**********Scheduled:" + UUID.randomUUID().toString().substring(0,6));
        System.out.println("**********produceMsgScheduledQueue send ok");
    }

}
