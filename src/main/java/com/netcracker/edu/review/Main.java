package com.netcracker.edu.review;

import com.netcracker.edu.review.datajpa.models.Reviews;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication<ReviewRepository> {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class);
	}

	@Bean
	public CommandLineRunner demo(ReviewRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Reviews(1, "BlaBlaBla"));

		};
	}

	;
}
