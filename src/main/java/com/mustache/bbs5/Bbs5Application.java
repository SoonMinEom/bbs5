package com.mustache.bbs5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class Bbs5Application {

	public static void main(String[] args) {
		SpringApplication.run(Bbs5Application.class, args);
	}

}
