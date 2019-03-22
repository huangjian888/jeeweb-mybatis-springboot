package com.company.manerger.sys.common.queue.listener;

import com.company.manerger.sys.common.queue.bean.ClusterBean;
import com.company.manerger.sys.common.queue.bean.EventTopicBean;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.Message;
import com.hazelcast.core.MessageListener;
import org.apache.commons.lang3.StringUtils;

/**
 * 重新选举hazelcast 的master节点
 * 主要是记录哪一个节点是第一个启动的，第一个启动的节点可能需要干些其他事件
 */
public class ClusterMasterTopicListener implements MessageListener<Object> {
    private HazelcastInstance hazelcastInstance;

    public ClusterMasterTopicListener(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    @Override
    public void onMessage(Message<Object> message) {
        EventTopicBean eventTopicBean = (EventTopicBean) message.getMessageObject();
        if(hazelcastInstance != null && eventTopicBean != null && !StringUtils.isBlank(eventTopicBean.getHost())){
            ClusterBean.getInstance().setHost(eventTopicBean.getHost());
            ClusterBean.getInstance().setId(eventTopicBean.getId());
            ClusterBean.getInstance().setPort(eventTopicBean.getPort());
            ClusterBean.getInstance().setStartTime(eventTopicBean.getStartTime());
            if(hazelcastInstance.getCluster().getLocalMember().getStringAttribute("id").equals(eventTopicBean.getId())){
                ClusterBean.getInstance().setMaster(true);
            }else{
                ClusterBean.getInstance().setMaster(false);
            }
        }
    }
}
