package com.spurtti.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@EnableJpaRepositories
@EnableMongoRepositories
@EntityScan(basePackageClasses = {SpurttiApplication.class, Jsr310JpaConverters.class})
public class SpurttiApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpurttiApplication.class, args);
	}
}
