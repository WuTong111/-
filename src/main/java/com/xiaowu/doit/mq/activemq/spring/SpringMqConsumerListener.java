package com.xiaowu.doit.mq.activemq.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 类作用: 整合spring
 * 作者: 八月
 * 创建时间:  2021-06-18 10:15
 */
@Component
public class SpringMqConsumerListener implements MessageListener {


    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage){
            String s = null;
            try {
                s = ((TextMessage) message).getText();
                System.out.println("***********listener auto receive message : "+s+ "***********");
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        DefaultMessageListenerContainer jmsContainer = (DefaultMessageListenerContainer) ctx.getBean("jmsContainer");
    }
}
