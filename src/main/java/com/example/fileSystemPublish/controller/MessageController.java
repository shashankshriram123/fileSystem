package com.example.fileSystemPublish.controller;

import com.example.fileSystemPublish.dto.FileInformationDto;
import com.example.fileSystemPublish.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {
    private FileService fileService;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @PostMapping
    public void publish(@RequestBody FileInformationDto fileInformationDto){
        kafkaTemplate.send("fileSystem" , String.valueOf(fileInformationDto));

    }
}
