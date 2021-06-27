package com.datanexions.mgen.connect;

import com.datanexions.mgen.FileService;
import com.datanexions.mgen.csvinput.KafkaCsvInputComponent;
import com.datanexions.mgen.loopback.KafkaCouchbaseLoopbackComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@PropertySource("classpath:/application.yml")
public class ConnectFileTasks {
    @Autowired
    private KafkaCsvInputComponent kafkaCsvInputComponent;

    @Autowired
    private FileService fileService;

    @Value("${kafka-connect.input_files}")
    private String input_files;

    @Value("${kafka-connect.managed_files}")
    private String managed_files;

    @Value("${kafka-connect.rejected_files}")
    private String rejected_files;

    //private static final Logger log = LoggerFactory.getLogger(ConnectFileTasks.class);
    //private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRateString = "${kafka-connect.listing_interval}")
    public void listingFile() {
        try {
            // List the file on input_files folder
            //Creating a File object for directory
            File directoryPath = new File(input_files);
            //List of all files and directories
            String contents[] = directoryPath.list();
            if (contents != null) {
                System.out.println("List of files and directories in the specified directory:");
                for (int i = 0; i < contents.length; i++) {
                    //System.out.println(contents[i]);
                    try {
                        if (!fileService.isProcessingFile(contents[i])) {
                            FileProcessWorker worker = new FileProcessWorker(Path.of(input_files, contents[i]),
                                    Path.of(managed_files, contents[i]), Path.of(rejected_files, contents[i]),
                                    kafkaCsvInputComponent, fileService);
                            Thread thread = new Thread(worker);
                            thread.start();
                        }
                        else {
                            System.out.println("File " + contents[i] + " is being processed.");
                        }
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}