package com.numble.karrotmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KarrotMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(KarrotMarketApplication.class, args);
	}

}
