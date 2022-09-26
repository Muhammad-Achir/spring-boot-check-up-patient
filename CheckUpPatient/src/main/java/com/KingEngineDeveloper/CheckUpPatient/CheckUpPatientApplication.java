package com.KingEngineDeveloper.CheckUpPatient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CheckUpPatientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckUpPatientApplication.class, args);
	}

}
