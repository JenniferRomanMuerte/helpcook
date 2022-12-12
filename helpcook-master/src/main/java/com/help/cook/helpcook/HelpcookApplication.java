package com.help.cook.helpcook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.help.cook.helpcook.repository")
public class HelpcookApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpcookApplication.class, args);
	}

}
