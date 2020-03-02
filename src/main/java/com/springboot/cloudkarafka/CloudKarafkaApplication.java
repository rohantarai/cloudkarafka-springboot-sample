package com.springboot.cloudkarafka;

import com.springboot.cloudkarafka.model.Message;
import com.springboot.cloudkarafka.producer.Producer;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CloudKarafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudKarafkaApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(Producer producer) {
		return (args) -> {
			for (int i = 1; i < 20; i++) {
				producer.send(new Message(i, "A simple test message"));
			}
		};
	}

}
