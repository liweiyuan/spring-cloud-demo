package com.wade.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringmsDiscoveryEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmsDiscoveryEurekaApplication.class, args);
	}
}
