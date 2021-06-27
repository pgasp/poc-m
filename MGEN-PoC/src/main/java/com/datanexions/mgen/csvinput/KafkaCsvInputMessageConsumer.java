package com.datanexions.mgen.csvinput;

import com.datanexions.mgen.FileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KafkaCsvInputMessageConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaCsvInputMessageConsumer.class);

    private String message = null;
    @Autowired
    FileService fileService;

    @KafkaListener(topics = "${kafka.topic.csvInputTopic}")
    public void receive(String payload) {
        LOGGER.info("Received payload='{}'", payload);
        this.message = payload;

        fileService.processCSVData(payload, "ftp_Kafka");

        /*
        // ObjectMapper instantiation
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Deserialization into a Map
            Map<String, Object> result = objectMapper.readValue(this.message, HashMap.class);
            var payloadData = (Map<String, Object>) result.get("payload");
            if (payloadData != null){
                var message = (String) payloadData.get("message");
                var headers = (List<String>) payloadData.get("headers");
                if ((message != null) && (headers != null) && (headers.size() > 0)){
                    String csv = headers.get(0) + "\n" + message;
                    fileService.processCSVData(csv, "ftp_Kafka");
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

         */
    }

    //added for testing purpose
    public String message(){return this.message;}
}
