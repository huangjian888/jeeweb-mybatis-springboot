package com.company.manerger.sys.common.mq.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMqListener {

    @KafkaListener(topics = {"kafka-topic"})
    public void receiveMessage(String message){
        /**
         *
         */
    }
}
