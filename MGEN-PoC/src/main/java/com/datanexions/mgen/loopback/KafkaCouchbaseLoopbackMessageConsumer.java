package com.datanexions.mgen.loopback;

import com.couchbase.client.java.json.JsonObject;
import com.datanexions.mgen.FileService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import java.util.HashMap;
import java.util.Map;

public class KafkaCouchbaseLoopbackMessageConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaCouchbaseLoopbackMessageConsumer.class);

    @Autowired
    FileService fileService;

    @KafkaListener(topics = "${kafka.topic.loopbackTopic}")
    public void receive(String payload) {
        LOGGER.info("Received payload='{}'", payload);
        try {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<HashMap<String, Object>> typeRef
                    = new TypeReference<HashMap<String, Object>>() {
            };
            Map<String, Object> docInfo = mapper.readValue(payload, typeRef);
            var id = (String) docInfo.get("id");
            if (id != null){
                var d = (Map<String, String>)docInfo.get("d");
                if (d != null){
                    JsonObject obj = JsonObject.from(d);
                    if (obj != null){
                        fileService.upsertLoopbackDocument(obj,  id);
                    }
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
