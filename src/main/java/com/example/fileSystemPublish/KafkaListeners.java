package com.example.fileSystemPublish;

import com.example.fileSystemPublish.model.FileInformation;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "fileSystem", groupId = "groupId")
    void listener(FileInformation data){
        System.out.println("LISTENER RECEIVED DATA : " + data.toString()  + " 🏎️" );

    }
}
