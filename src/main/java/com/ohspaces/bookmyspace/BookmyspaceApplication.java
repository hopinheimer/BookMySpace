package com.ohspaces.bookmyspace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@PropertySource(value = "classpath:${spring.profiles.active}/service.config.properties")
@ComponentScan(basePackages = { "com.ohspaces.bookmyspace.**" })
@EntityScan(basePackages = { "com.ohspaces.bookmyspace.**" })
@EnableJpaRepositories(basePackages = { "com.ohspaces.bookmyspace.**" })
@EnableWebMvc
public class BookmyspaceApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookmyspaceApplication.class, args);
	}

}


