package com.xiaowu.doit.mq.activemq;

import com.xiaowu.doit.mq.activemq.springboot.QueueProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;


@SpringBootTest(classes = MainAppProduce.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestActiveMQ {
    @Resource
    private QueueProducer producer;


    @Test
    public void testSend() throws Exception{
        producer.produceMsg();
    }

}
