package org.study.xiaowu.mq.activemq.broker;

import org.apache.activemq.broker.BrokerService;

/**
 * 类作用: 嵌入式broker
 * 作者: 八月
 * 创建时间:  2021-06-17 22:58
 */
public class EmbedBroker {
    public static void main(String[] args) throws Exception {
        BrokerService brokerService = new BrokerService();
        brokerService.setUseJmx(true);
        brokerService.addConnector("tcp://localhost:61616");
        brokerService.start();
    }
}
