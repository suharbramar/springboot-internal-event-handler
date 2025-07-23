package com.bramar.spring.internaleventhandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class InternalEventHandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternalEventHandlerApplication.class, args);
	}

}
