package com.company.manerger.sys.common.queue.listener;

import com.corundumstudio.socketio.SocketIOClient;
import com.company.manerger.sys.common.queue.bean.EventTopicBean;
import com.company.manerger.sys.common.queue.clients.NettySockIoClients;
import com.hazelcast.core.Message;
import com.hazelcast.core.MessageListener;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class OnLineUserTopicListener implements MessageListener<Object> {
    @Override
    public void onMessage(Message<Object> message) {
        EventTopicBean eventTopicBean = (EventTopicBean) message.getMessageObject();
        if(eventTopicBean != null && !StringUtils.isBlank(eventTopicBean.getId())){
            List<SocketIOClient> socketIOClientList = NettySockIoClients.getInstance().getOnLineUserClient().get(eventTopicBean.getId());
            if(socketIOClientList != null && socketIOClientList.size() > 0){
                for(SocketIOClient socketIOClient : socketIOClientList){
                    socketIOClient.sendEvent(eventTopicBean.getEvent(),eventTopicBean.getData());
                }
            }
        }
    }
}
