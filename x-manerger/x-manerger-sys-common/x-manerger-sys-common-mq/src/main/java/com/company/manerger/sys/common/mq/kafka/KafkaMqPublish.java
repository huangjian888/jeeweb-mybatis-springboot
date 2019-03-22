package com.company.manerger.sys.common.mq.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaMqPublish {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void send(String topic,String message){
        kafkaTemplate.send(topic, message);
    }
}
