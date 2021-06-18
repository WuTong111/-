package org.study.xiaowu.mq.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 类作用: Jms消息消费者
 * 作者: 八月
 * 创建时间:  2021-06-17 16:37
 * @author ACER
 */
public class JmsConsumer {
    //普通tcp连接
//    private static final String ACTIVEMQ_URL = "tcp://192.168.1.231:61616";
    //故障转移策略
//    private static final String ACTIVEMQ_URL = "failover:(tcp://10.218.34.4:21616)?randomize=false&timeout=10000";
    private static final String ACTIVEMQ_URL = "tcp://localhost:61616";

    private static final String QUEUE_NAME = "queue1";
    private static final String TOPIC_NAME = "welcome_into_activemq_world_topic";

    public static void main(String[] args) throws Exception{
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //2.通过连接工厂、获得连接connection并启动访问
        Connection connection = connectionFactory.createConnection();
        long start = System.currentTimeMillis();
        connection.start();
        long end = System.currentTimeMillis();
        System.out.println("-------耗时:"+(end-start)/1000);
        //3.创建会话session,    第一个叫事务/第二个叫签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4 创建目的地（具体是队列Queue还是主题Topic）
        Queue queue = session.createQueue(QUEUE_NAME);
        //5.创建消费者
        MessageConsumer consumer = session.createConsumer(queue);
        while (true){
            TextMessage message = (TextMessage) consumer.receive();
            if (message != null){
                System.out.println("*****消费者接收到消息："+message.getText());
            }else {
                break;
            }
        }
        //7.关闭资源
        consumer.close();
        session.close();
        connection.close();

    }
}
