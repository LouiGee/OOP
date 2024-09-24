package com.ratify;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableJpaAuditing
@EnableAsync
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@RequiredArgsConstructor

public class RatifyApplication {





	public static void main(String[] args) {
		SpringApplication.run(RatifyApplication.class, args);
	}


}




