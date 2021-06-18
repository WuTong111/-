package com.xiaowu.doit.mq.activemq.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * 类作用: 整合spring
 * 作者: 八月
 * 创建时间:  2021-06-18 10:15
 */
@Service
public class SpringMqConsumer {

    public static void main(String[] args) throws JMSException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        JmsTemplate jmsTemplate = (JmsTemplate) ctx.getBean("jmsTemplate");
        Message message = jmsTemplate.receive();
        if (message instanceof TextMessage){
            String s = ((TextMessage) message).getText();
            System.out.println("***********receive message : "+s+ "***********");
        }
    }

}
