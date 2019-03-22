package com.company.manerger.sys.common.queue.config;

import com.company.manerger.sys.common.idgenerator.local.LocalIdGenerator;
import com.company.manerger.sys.common.queue.enums.EventTopic;
import com.company.manerger.sys.common.queue.listener.*;
import com.company.manerger.sys.common.queue.utils.EventUtils;
import com.hazelcast.config.ClasspathXmlConfig;
import com.hazelcast.config.Config;
import com.hazelcast.config.MapAttributeConfig;
import com.hazelcast.config.MapIndexConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.hazelcast.HazelcastSessionRepository;
import org.springframework.session.hazelcast.PrincipalNameExtractor;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

/**
 * 采用spring session，将httpseesion交由spring seesion进行管理
 * 使用Hazelcast httpsession
 */
@Configuration
@EnableHazelcastHttpSession(maxInactiveIntervalInSeconds = 3600)
@ComponentScan({
        "com.company.manerger.sys.common.idgenerator"
})
public class HazelcastConfig {
    @Value("${idgenerator.dataCenterId}")
    private long dataCenterId;
    @Value("${idgenerator.machineId}")
    private long machineId;
    @Autowired
    private LocalIdGenerator idGenerator;

    @Bean
    public HazelcastInstance hazelcastInstance() throws Exception {
        MapAttributeConfig attributeConfig = new MapAttributeConfig()
                .setName(HazelcastSessionRepository.PRINCIPAL_NAME_ATTRIBUTE)
                .setExtractor(PrincipalNameExtractor.class.getName());
        Config config = new ClasspathXmlConfig("hazelcast.xml");
        config.getMapConfig("spring:session:sessions")
                .addMapAttributeConfig(attributeConfig)
                .addMapIndexConfig(new MapIndexConfig(HazelcastSessionRepository.PRINCIPAL_NAME_ATTRIBUTE, false));
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(config);
        hazelcastInstance.getTopic(EventTopic.EVENT_TOPIC_VOTE.toString()).addMessageListener(new ClusterMasterTopicListener(hazelcastInstance));
        hazelcastInstance.getTopic(EventTopic.EVENT_TOPIC_ONLINEUSERClIENT.toString()).addMessageListener(new OnLineUserTopicListener());
        hazelcastInstance.getTopic(EventTopic.EVENT_TOPIC_QUEUEUPCLIENT.toString()).addMessageListener(new QueueUpClientTopicListener());
        hazelcastInstance.getTopic(EventTopic.EVENT_TOPIC_BROADCAST.toString()).addMessageListener(new BroadcastTopicListener());
        hazelcastInstance.getTopic(EventTopic.EVENT_TOPIC_EVENTHANDLER.toString()).addMessageListener(new EventHandlerTopicListener());
        hazelcastInstance.getTopic(EventTopic.EVENT_TOPIC_CHECKQUEUEUP.toString()).addMessageListener(new CheckQueueUpTopicListener());
        hazelcastInstance.getCluster().addMembershipListener(new ClusterMemberShipTopicListener(hazelcastInstance));
        hazelcastInstance.getCluster().getLocalMember().setStringAttribute("id",idGenerator.nextUniqueId(dataCenterId,machineId));
        hazelcastInstance.getCluster().getLocalMember().setLongAttribute("startTime",System.currentTimeMillis());
        EventUtils.voteHazelcastMaster(hazelcastInstance);
        return hazelcastInstance;
    }
}
