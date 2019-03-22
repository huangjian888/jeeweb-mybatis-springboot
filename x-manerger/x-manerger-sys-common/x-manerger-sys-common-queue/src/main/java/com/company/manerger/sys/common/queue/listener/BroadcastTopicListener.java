package com.company.manerger.sys.common.queue.listener;

import com.corundumstudio.socketio.SocketIONamespace;
import com.company.manerger.sys.common.queue.bean.EventTopicBean;
import com.company.manerger.sys.common.utils.SpringContextHolder;
import com.hazelcast.core.Message;
import com.hazelcast.core.MessageListener;
import org.apache.commons.lang3.StringUtils;

public class BroadcastTopicListener implements MessageListener<Object> {
    @Override
    public void onMessage(Message<Object> message) {
        EventTopicBean eventTopicBean = (EventTopicBean) message.getMessageObject();
        if(eventTopicBean != null && !StringUtils.isBlank(eventTopicBean.getId())){
            SpringContextHolder.getApplicationContext().getBean(eventTopicBean.getId(), SocketIONamespace.class).getBroadcastOperations().sendEvent(eventTopicBean.getEvent(),eventTopicBean.getData());
        }
    }
}
