package com.company.manerger.sys.common.queue.enums;

/**
 * 事件(主题)订阅类型
 */
public enum EventTopic {
    /**
     * 选举Hazelcast master节点
     */
    EVENT_TOPIC_VOTE("EventTopicVote"),
    EVENT_TOPIC_ONLINEUSERClIENT("EventTopicOnLineUserClient"),
    EVENT_TOPIC_QUEUEUPCLIENT("EventTopicQueueUpClient"),
    EVENT_TOPIC_BROADCAST("EventTopicBroadcast"),
    EVENT_TOPIC_EVENTHANDLER("EventTopicEventHandler"),
    EVENT_TOPIC_CHECKQUEUEUP("EventTopicCheckQueueUp")
    ;
    private String value;
    private EventTopic(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    @Override
    public String toString() {
       return value;
    }
}
