package com.example.fileSystemPublish.service.impl;

import com.example.fileSystemPublish.dto.FileInformationDto;
import com.example.fileSystemPublish.model.FileInformation;
import com.example.fileSystemPublish.service.FileService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String publishMessage(FileInformationDto fileInformationDto) {
        FileInformation fileInformation = mapToEntity(fileInformationDto);

        return fileInformation.toString();
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
