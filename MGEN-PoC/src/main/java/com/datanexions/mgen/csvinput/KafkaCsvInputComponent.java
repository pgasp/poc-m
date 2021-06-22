package com.datanexions.mgen.csvinput;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * SimpleKafkaMessaging uses Spring Boot CommandLineRunner to send 100 consecutive messages to Kafka server
 */
@Component
public class KafkaCsvInputComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaCsvInputComponent.class);

    @Autowired
    private KafkaCsvInputMessageProducer sender;

    @Value("${kafka.topic.csvInputTopic}")
    private String topicName;

    public void execute() {
        LOGGER.info("KafkaCsvInputComponent is executing...");
        for (int i = 0; i < 100; ++i) {
            sender.send(topicName, "SimpleKafkaMessaging - Message No = " + i);
        }
    }

    @Bean
    public KafkaCsvInputMessageProducer simpleKafkaMessageProducer(){
        return new KafkaCsvInputMessageProducer();
    }

    @Bean
    public KafkaCsvInputMessageConsumer simpleKafkaMessageConsumer(){
        return new KafkaCsvInputMessageConsumer();
    }
}
