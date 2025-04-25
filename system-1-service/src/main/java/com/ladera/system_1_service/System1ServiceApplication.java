package com.ladera.system_1_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class System1ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(System1ServiceApplication.class, args);
	}

}
