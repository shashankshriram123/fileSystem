package com.example.fileSystemPublish.consumer;

import com.example.fileSystemPublish.kafkaConfig.AppConstant;
import com.example.fileSystemPublish.model.FileInformation;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    @KafkaListener(topics = AppConstant.FILE_SYSTEM, groupId = "group-id")
    void listener(FileInformation fileInformation){
        System.out.println("⚠️LISTENER RECEIVED FILE : " + fileInformation + " ⚠️");
    }

}
