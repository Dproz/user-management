package com.ceitechs.dproz.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "com.ceitechs.dproz")
@EnableDiscoveryClient
public class UserManagementApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(UserManagementApplication.class, args);
	}
}
