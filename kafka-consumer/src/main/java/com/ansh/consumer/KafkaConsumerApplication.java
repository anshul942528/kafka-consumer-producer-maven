package com.ansh.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class KafkaConsumerApplication {

	public static void main(String[] args) {
		log.info("Kafka consumer is starting");
		SpringApplication.run(KafkaConsumerApplication.class, args);
	}

}
