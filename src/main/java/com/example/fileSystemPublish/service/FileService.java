package com.example.fileSystemPublish.service;

import com.example.fileSystemPublish.dto.FileInformationDto;

public interface FileService {
    //String publishMessage(FileInformationDto fileInformationDto);
    void saveCreateFile(FileInformationDto fileInformationDto);

}
