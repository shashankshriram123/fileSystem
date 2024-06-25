package com.example.fileSystemPublish.config.customSerializerDeserializer;

import com.example.fileSystemPublish.model.FileInformation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.springframework.core.serializer.Serializer;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

public class FileInformationSerializer implements Serializer<FileInformation> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    public byte[] serialize(String topic, FileInformation data) {
        try {
            if (data == null){
                System.out.println("Null received at serializing");
                return null;
            }
            System.out.println("Serializing...");
            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            throw new SerializationException("Error when serializing MessageDto to byte[]");
        }
    }

    public void close() {
    }

    @Override
    public void serialize(FileInformation object, OutputStream outputStream) throws IOException {

    }
}
