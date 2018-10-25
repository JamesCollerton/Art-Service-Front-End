package com.artservicefrontend.artservicefrontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
TODO: Comments
TODO: Swagger
TODO: Testing
TODO: Docker
 */
@EnableFeignClients
@SpringBootApplication
public class ArtServiceFrontEndApplication {
	public static void main(String[] args) {
		SpringApplication.run(ArtServiceFrontEndApplication.class, args);
	}
}
