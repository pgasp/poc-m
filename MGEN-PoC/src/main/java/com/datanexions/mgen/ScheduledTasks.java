package com.datanexions.mgen;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.datanexions.mgen.loopback.KafkaCouchbaseLoopbackComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    @Autowired
    private KafkaCouchbaseLoopbackComponent kafkaCouchbaseLoopbackComponent;

    //private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    //private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        //log.info("The time is now {}", dateFormat.format(new Date()));
        kafkaCouchbaseLoopbackComponent.execute();
    }
}