package com.company.manerger.sys.common.queue.listener;

import com.corundumstudio.socketio.SocketIOClient;
import com.company.manerger.sys.common.queue.bean.EventTopicBean;
import com.company.manerger.sys.common.queue.cache.hazelcast.HazelcastCacheHelper;
import com.company.manerger.sys.common.queue.entity.QueueUp;
import com.company.manerger.sys.common.queue.service.impl.QueueUpImpl;
import com.company.manerger.sys.common.queue.service.messages.PacketsMessage;
import com.company.manerger.sys.common.queue.utils.EventUtils;
import com.hazelcast.core.IMap;
import com.hazelcast.core.Message;
import com.hazelcast.core.MessageListener;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class CheckQueueUpTopicListener implements MessageListener<Object> {
    @Override
    public void onMessage(Message<Object> message) {
        /**
         * 检查排队，取排队最靠前的用户进行逻辑处理
         * 删除BusinessCacheBean 中业务处理完毕的用户信息
         */
        EventTopicBean eventTopicBean = (EventTopicBean) message.getMessageObject();
        if(eventTopicBean != null){
            String userid = eventTopicBean.getId();
            PacketsMessage packetsMessage = (PacketsMessage) eventTopicBean.getData();
            SocketIOClient client = packetsMessage.getClient();
            QueueUpImpl.updateQueueUpCacheBean(userid,client); //更新排队客户端排队状态
            /**
             * 筛选队列中当前排队数最小的用户
             */
            Collection<QueueUp> queueUpList = (Collection<QueueUp>) ((IMap<String, QueueUp>)HazelcastCacheHelper.getInstance().getQueueUpCacheBean().getAllHazelcastCacheObject());
            if(queueUpList != null && queueUpList.size() > 0){
                QueueUp queueUp = Collections.min(queueUpList,new Comparator<QueueUp>(){
                    @Override
                    public int compare(QueueUp o1, QueueUp o2) {
                        return (int)(o1.getCurrentQueueUpNum() - o2.getCurrentQueueUpNum());
                    }
                });

                /**
                 * 排队队列中有排队用户，将排队最小值的用户事件发给EventHandlerTopicListener 进行处理，并且制定特殊事件，删除当前已经处理完毕用户的deleteToBusinessCacheBean 信息
                 * deleteToBusinessCacheBean需要在EventHandlerTopicListener 进行删除
                 */
                queueUp.getPacketsMessage().setSubPacketsMessage(packetsMessage);
                EventUtils.sendEventHandler(queueUp.getUserid(),queueUp.getPacketsMessage().getEvent(),queueUp.getPacketsMessage());
            }else {
                /**
                 * 排队队列中没有排队用户，直接删除缓存信息
                 */
                QueueUpImpl.deleteToBusinessCacheBean(userid);
            }
        }
    }
}
