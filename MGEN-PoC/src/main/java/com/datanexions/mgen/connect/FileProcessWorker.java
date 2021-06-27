package com.datanexions.mgen.connect;

import com.datanexions.mgen.FileService;
import com.datanexions.mgen.csvinput.KafkaCsvInputComponent;
import com.datanexions.mgen.loopback.KafkaCouchbaseLoopbackComponent;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class FileProcessWorker implements Runnable {
    private Path fileToRead;
    private Path fileManaged;
    private Path fileRejected;
    private KafkaCsvInputComponent kafkaCsvInputComponent;
    private FileService fileService;

    public FileProcessWorker(Path filePath, Path fileManagedPath, Path fileRejectedPath,
                             KafkaCsvInputComponent kafkaCsvInput, FileService service) {
        fileToRead = filePath;
        fileManaged = fileManagedPath;
        fileRejected = fileRejectedPath;
        kafkaCsvInputComponent = kafkaCsvInput;
        fileService = service;
    }

    @Override
    public void run() {
        try {
            fileService.processFileStarted(fileToRead.getFileName().toString());

            FileInputStream inputStream = null;
            Scanner sc = null;
            try {
                inputStream = new FileInputStream(fileToRead.toFile());
                sc = new Scanner(inputStream, "UTF-8");
                String header = null;
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    // System.out.println(line);
                    if (header == null) {
                        header = line;
                    } else {
                        var value = header + "\n" + line;
                        kafkaCsvInputComponent.execute(value);
                    }
                }
                // note that Scanner suppresses exceptions
                if (sc.ioException() != null) {
                    throw sc.ioException();
                }

                // Move file to managed folder
                Files.move(fileToRead, fileManaged, StandardCopyOption.REPLACE_EXISTING);

            } catch (Exception e) {
                e.printStackTrace();

                // Move file to managed folder
                Files.move(fileToRead, fileRejected, StandardCopyOption.REPLACE_EXISTING);
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (sc != null) {
                    sc.close();
                }
            }
        } catch (Exception ex) {

        }
        finally {
            fileService.processFileFinished(fileToRead.getFileName().toString());
        }
    }
}