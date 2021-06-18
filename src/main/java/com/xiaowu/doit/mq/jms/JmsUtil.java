package org.study.xiaowu.mq.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.Session;

/**
 * 类作用: jms工具类
 * 作者: 八月
 * 创建时间:  2021-06-17 21:07
 */
public class JmsUtil {
    //普通tcp连接
//    private static final String ACTIVEMQ_URL = "tcp://192.168.1.231:61616";
    //故障转移策略
    private static final String ACTIVEMQ_URL = "failover:(tcp://10.218.34.4:21616)?randomize=false&timeout=10000";

    public static Session startJms() throws Exception{
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //2.通过连接工厂、获得连接connection并启动访问
        Connection connection = connectionFactory.createConnection();
        long start = System.currentTimeMillis();
        connection.start();
        long end = System.currentTimeMillis();
        System.out.println("-------耗时:"+(end-start)/1000);
        //3.创建会话session,    第一个叫事务/第二个叫签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        return session;
    }
}
