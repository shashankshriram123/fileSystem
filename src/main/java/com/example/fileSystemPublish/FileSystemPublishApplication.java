package com.example.fileSystemPublish;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class FileSystemPublishApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileSystemPublishApplication.class, args);
	}


}
