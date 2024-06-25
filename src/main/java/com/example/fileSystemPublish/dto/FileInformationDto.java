package com.example.fileSystemPublish.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FileInformationDto {
    private long id;
    private String sender;
    private String receiver;
    private String message;
}
