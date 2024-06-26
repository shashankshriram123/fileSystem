package com.example.fileSystemPublish.service.impl;

import com.example.fileSystemPublish.dto.FileInformationDto;
import com.example.fileSystemPublish.kafkaConfig.AppConstant;
import com.example.fileSystemPublish.model.FileInformation;
import com.example.fileSystemPublish.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;
import java.time.LocalDateTime;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void saveCreateFile(FileInformationDto fileInformationDto) {
        FileInformation fileInformation = mapToEntity(fileInformationDto);

        //logger.info(String.format("User created -> %s", fileInformation));
        System.out.println("FILE CREATED -> " + fileInformation);
        this.kafkaTemplate.send(AppConstant.FILE_SYSTEM, fileInformation);

    }


    private FileInformation mapToEntity(FileInformationDto fileInformationDto){
        FileInformation fileInformation = new FileInformation();
        fileInformation.setReceiver(fileInformationDto.getReceiver());
        fileInformation.setSender(fileInformationDto.getSender());
        fileInformation.setMessage(fileInformationDto.getMessage());
        fileInformation.setTimeStamp(LocalDateTime.now());

        return fileInformation;

    }



}
