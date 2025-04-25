package com.ladera.system_2_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class System2ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(System2ServiceApplication.class, args);
	}

}
