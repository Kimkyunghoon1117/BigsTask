package com.task.inquireapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.task")
@EnableJpaRepositories("com.task")
@SpringBootApplication(scanBasePackages = "com.task")
public class InquireApplication {

	public static void main(String[] args) {
		SpringApplication.run(InquireApplication.class, args);
	}

}
