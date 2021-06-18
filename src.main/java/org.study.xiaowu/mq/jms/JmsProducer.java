package org.study.xiaowu.mq.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 类作用: 消息生产者
 * 作者: 八月
 * 创建时间:  2021-06-17 16:43
 */
public class JmsProducer {
    //普通tcp连接
//    private static final String ACTIVEMQ_URL = "tcp://192.168.1.231:61616";
    //故障转移策略
//    private static final String ACTIVEMQ_URL = "failover:(tcp://10.218.34.4:21616)?randomize=false&timeout=10000";
    //内嵌broker实例地址
    private static final String ACTIVEMQ_URL = "tcp://localhost:61616";
    private static final String QUEUE_NAME = "queue1";
    public static void main(String[] args) throws JMSException, InterruptedException {
        //1.创建连接工厂、按照给定得url地址、采用默认用户名和编码
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //2.通过连接工厂、获得连接connection并启动访问
        Connection connection = connectionFactory.createConnection();
        long start = System.currentTimeMillis();
        connection.start();
        long end = System.currentTimeMillis ();
        System.out.println("-------耗时:"+(end-start)/1000);
        Thread.sleep(5000);
        //3.创建会话session,    第一个叫事务/第二个叫签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4 创建目的地（具体是队列Queue还是主题Topic）
        Queue queue = session.createQueue(QUEUE_NAME);
        //5.创建消息生产者
        MessageProducer messageProducer = session.createProducer(queue);
        messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
        //6.通过使用消息生产者producer发送消息
        for (int i = 0; i < 3; i++) {
            System.out.println("*********发送第"+i+"条消息：");
            TextMessage message = session.createTextMessage("msg----瑶瑶攻击---hp-" + i);

        }
        //7.关闭资源
        messageProducer.close();
        session.close();
        connection.close();
    }
}
