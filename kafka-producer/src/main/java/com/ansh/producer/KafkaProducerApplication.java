package com.ansh.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ansh.producer.model.User;
import com.ansh.producer.service.ProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class KafkaProducerApplication implements CommandLineRunner {

	@Autowired
	private ProducerService producerService;

	public static void main(String[] args) {
		log.info("Kafka producer is starting");
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for(int i = 0; i < 5; i ++) {
			ObjectMapper mapper = new ObjectMapper();
			User user = new User("anshul", i + 1, "M");
			producerService.sendMessage(mapper.writeValueAsString(user));
		}
	}
}
