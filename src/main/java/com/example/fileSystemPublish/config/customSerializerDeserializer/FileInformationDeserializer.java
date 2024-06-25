package com.example.fileSystemPublish.config.customSerializerDeserializer;

import com.example.fileSystemPublish.model.FileInformation;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.SerializationException;
import org.springframework.core.serializer.Deserializer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Slf4j
public class FileInformationDeserializer implements Deserializer<FileInformation> {
    private ObjectMapper objectMapper = new ObjectMapper();


    public void configure(Map<String, ?> configs, boolean isKey) {
    }


    public FileInformation deserialize(String topic, byte[] data) {
        try {
            if (data == null){
                System.out.println("Null received at deserializing");
                return null;
            }
            System.out.println("Deserializing...");
            return objectMapper.readValue(new String(data, "UTF-8"), FileInformation.class);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to MessageDto");
        }
    }


    public void close() {
    }

    @Override
    public FileInformation deserialize(InputStream inputStream) throws IOException {
        return null;
    }
}
