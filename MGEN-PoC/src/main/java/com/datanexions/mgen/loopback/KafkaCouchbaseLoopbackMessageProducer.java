package com.datanexions.mgen.loopback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class KafkaCouchbaseLoopbackMessageProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaCouchbaseLoopbackMessageProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, String payload){
        LOGGER.info("Sending payload='{}' to topic='{}' with key='{}'", payload, topic);
        kafkaTemplate.send(topic, payload);
    }
}
