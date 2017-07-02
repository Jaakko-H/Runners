package fi.runners.runners;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.*;
import org.springframework.boot.autoconfigure.orm.jpa.*;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class RunnersApplication {
	public static void main(String[] args) {
		SpringApplication.run(RunnersApplication.class, args);
	}
}
