package com.company.manerger.sys.common.queue.listener;

import com.company.manerger.sys.common.queue.bean.EventTopicBean;
import com.company.manerger.sys.common.queue.service.impl.QueueUpImpl;
import com.company.manerger.sys.common.queue.service.messages.PacketsMessage;
import com.company.manerger.sys.common.queue.utils.EventUtils;
import com.hazelcast.core.Message;
import com.hazelcast.core.MessageListener;

public class EventHandlerTopicListener implements MessageListener<Object> {
    @Override
    public void onMessage(Message<Object> message) {
        EventTopicBean eventTopicBean = (EventTopicBean) message.getMessageObject();
        if(eventTopicBean != null){
            /**
             * 检查消息中是否含有特定事件，如deleteToBusinessCacheBean，删除deleteToBusinessCacheBean中缓存的用户
             *
             */
            PacketsMessage packetsMessage = (PacketsMessage) eventTopicBean.getData();
            PacketsMessage subPacketsMessage = packetsMessage.getSubPacketsMessage();
            if(subPacketsMessage != null){
                String userid = subPacketsMessage.getUserid();
                QueueUpImpl.deleteToBusinessCacheBean(userid);
            }
            try {
                Thread.sleep(10000); //模拟业务处理过程
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /**
             * 将事件处理完毕消息发给 CheckQueueUpTopicListener
             * 当业务处理完后，判断当前业务的排队队列是否有数据，若有数据，需要重新重新计算排队数并通知客户端当前排队状态，然后从排队队列中取出最前面的用户进行业务处理
             */
            EventUtils.sendCheckQueueUpEventMessage(eventTopicBean.getId(),eventTopicBean.getEvent(),eventTopicBean.getData());
        }
    }

}
