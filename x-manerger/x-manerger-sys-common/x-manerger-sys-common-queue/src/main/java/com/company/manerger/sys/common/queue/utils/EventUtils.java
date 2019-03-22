package com.company.manerger.sys.common.queue.utils;

import com.company.manerger.sys.common.queue.bean.EventTopicBean;
import com.company.manerger.sys.common.queue.enums.EventTopic;
import com.company.manerger.sys.common.utils.SpringContextHolder;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.Member;

import java.util.Set;

public class EventUtils {
    public static void voteHazelcastMaster(HazelcastInstance hazelcastInstance){
        Set<Member> members = hazelcastInstance.getCluster().getMembers();
        Member master = null;
        for(Member member : members){
            if (master == null || (member != null && member.getLongAttribute("startTime") != null && member.getLongAttribute("startTime") < master.getLongAttribute("startTime"))) {
                master = member;
            }
        }
        if(master != null){
            hazelcastInstance.getTopic(EventTopic.EVENT_TOPIC_VOTE.toString()).publish(new EventTopicBean(master.getStringAttribute("id"),master.getLongAttribute("startTime"),master.getAddress().getHost(),master.getAddress().getPort()));
        }
    }

    public static void sendOnLineUserClientEventMessage(String key,String event,Object message){
        SpringContextHolder.getBean(HazelcastInstance.class).getTopic(EventTopic.EVENT_TOPIC_ONLINEUSERClIENT.toString()).publish(new EventTopicBean(key,event,message));
    }
    public static void sendQueueUpClientEventMessage(String key,String event,Object message){
        SpringContextHolder.getBean(HazelcastInstance.class).getTopic(EventTopic.EVENT_TOPIC_QUEUEUPCLIENT.toString()).publish(new EventTopicBean(key,event,message));
    }
    /**
     * 根据beanName来发送到指定的SocketIONamespace 进行消息的广播
     * @param beanName
     * @param event
     * @param message
     */
    public static void sendBroadcastEventMessage(String beanName,String event,Object message){
        SpringContextHolder.getBean(HazelcastInstance.class).getTopic(EventTopic.EVENT_TOPIC_BROADCAST.toString()).publish(new EventTopicBean(beanName,event,message));
    }
    public static void sendEventHandler(String key,String event,Object message){
        SpringContextHolder.getBean(HazelcastInstance.class).getTopic(EventTopic.EVENT_TOPIC_EVENTHANDLER.toString()).publish(new EventTopicBean(key,event,message));
    }
    public static void sendCheckQueueUpEventMessage(String key,String event,Object message){
        SpringContextHolder.getBean(HazelcastInstance.class).getTopic(EventTopic.EVENT_TOPIC_CHECKQUEUEUP.toString()).publish(new EventTopicBean(key,event,message));
    }
}
