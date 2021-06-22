package com.datanexions.mgen.loopback;

import com.couchbase.client.java.json.JsonObject;
import com.datanexions.mgen.FileService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class KafkaCouchbaseLoopbackComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaCouchbaseLoopbackComponent.class);

    @Autowired
    private KafkaCouchbaseLoopbackMessageProducer sender;

    @Autowired
    FileService fileService;

    @Value("${kafka.topic.loopbackTopic}")
    private String topicName;

    public void execute() {
        LOGGER.info("KafkaCouchbaseLoopbackComponent is executing...");
        /*
        for (int j = 0; j < 10 ; j++) {
            try {
                Thread.sleep(10);     //add some lag to producer
                for (int i = 0; i < 100; ++i) {
                    sender.send(topicName, "BatchMessageConsuming - Message No = " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
         */
        // Get the last documents
        var docs = fileService.getLastUpdatedDocuments();
        if ((docs != null) && (docs.size() > 0)){
            for (var doc: docs){
                //var value = doc.toMap().toString();
                try {
                    String json = new ObjectMapper().writeValueAsString(doc.toMap());
                    System.out.println(json);


                    /////////////
                    // Test
                    /*
                    try {
                        ObjectMapper mapper = new ObjectMapper();
                        TypeReference<HashMap<String, Object>> typeRef
                                = new TypeReference<HashMap<String, Object>>() {
                        };
                        Map<String, Object> docInfo = mapper.readValue(json, typeRef);
                        var id = (String) docInfo.get("id");
                        if (id != null){
                            var d = (Map<String, String>)docInfo.get("d");
                            if (d != null){
                                JsonObject obj = JsonObject.from(d);
                                if (obj != null){

                                }
                            }
                        }
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    */
                    //////////////

                    sender.send(topicName, json);
                }
                catch (Exception e){

                }
            }
        }
        else {
            LOGGER.info("KafkaCouchbaseLoopbackComponent done witht no new document");
        }
    }

    @Bean
    public KafkaCouchbaseLoopbackMessageProducer messageProducer(){
        return new KafkaCouchbaseLoopbackMessageProducer();
    }

    @Bean
    public KafkaCouchbaseLoopbackMessageConsumer batchMessageConsumer(){
        return new KafkaCouchbaseLoopbackMessageConsumer();
    }
}
