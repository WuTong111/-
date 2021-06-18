package com.xiaowu.doit.mq.activemq.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.TextMessage;

/**
 * 类作用: 整合spring
 * 作者: 八月
 * 创建时间:  2021-06-18 10:15
 */
@Service
public class SpringMqProducer {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        JmsTemplate jmsTemplate = (JmsTemplate) ctx.getBean("jmsTemplate");
        jmsTemplate.send((session)->{
            TextMessage textMessage = session.createTextMessage("********spring与activeMQ整合*********");
            return textMessage;
        });
        System.out.println("***********send task over***********");
    }

}
