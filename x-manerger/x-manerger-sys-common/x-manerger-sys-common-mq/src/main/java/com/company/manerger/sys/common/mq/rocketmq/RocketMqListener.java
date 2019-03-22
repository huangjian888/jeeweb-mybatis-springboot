package com.company.manerger.sys.common.mq.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.common.UtilAll;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Configuration
public class RocketMqListener {
    /**
     * RocketMQMessageListener->MessageModel 消息模式默认为CLUSTERING集群消费(消费者模式) BROADCASTING为广播模式消费（订阅模式）
     */
    private final String txProducerGroup = "txProducerGroup";

    /**
     * 事务消息监听(生产者中)
     */
    @RocketMQTransactionListener(txProducerGroup = txProducerGroup)
    public class RocketMQLocalTransactionListenerImpl implements RocketMQLocalTransactionListener{

        @Override
        public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
            /**
             * 执行本地事务逻辑
             */
            return null;
        }

        @Override
        public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
            /**
             * 回查逻辑
             */
            return null;
        }
    }

    /**
     * 特殊标签发送消息->消费者监听
     */
    @Service
    @RocketMQMessageListener(topic = "message-ext-topic", selectorExpression = "tag", consumerGroup = "message-ext-consumer")
    public class MessageExtEventConsumer implements RocketMQListener<MessageExt>, RocketMQPushConsumerLifecycleListener {

        @Override
        public void onMessage(MessageExt messageExt) {

        }

        @Override
        public void prepareStart(DefaultMQPushConsumer defaultMQPushConsumer) {
            defaultMQPushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_TIMESTAMP);
            defaultMQPushConsumer.setConsumeTimestamp(UtilAll.timeMillisToHumanString3(System.currentTimeMillis()));
        }
    }

    @Service
    @RocketMQMessageListener(topic="string-topic",consumerGroup = "string-consumer")
    public class StringEventConsumer implements RocketMQListener<String>{

        @Override
        public void onMessage(String s) {

        }
    }

    /**
     * 事务消息消费者监听
     */
    @Service
    @RocketMQMessageListener(topic = "string-transaction-topic",consumerGroup = "string-transaction-consumer")
    public class StringTransactionalEventConsumer implements RocketMQListener<String>{

        @Override
        public void onMessage(String s) {

        }
    }

}
