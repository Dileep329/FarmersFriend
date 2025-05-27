package com.friend.farmers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FarmersApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmersApplication.class, args);
	}

}
