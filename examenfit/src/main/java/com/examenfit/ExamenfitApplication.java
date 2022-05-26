package com.examenfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ExamenfitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenfitApplication.class, args);
	}

}
