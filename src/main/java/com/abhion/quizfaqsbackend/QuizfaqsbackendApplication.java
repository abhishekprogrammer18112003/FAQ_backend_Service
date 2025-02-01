package com.abhion.quizfaqsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class QuizfaqsbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizfaqsbackendApplication.class, args);
	}

}
