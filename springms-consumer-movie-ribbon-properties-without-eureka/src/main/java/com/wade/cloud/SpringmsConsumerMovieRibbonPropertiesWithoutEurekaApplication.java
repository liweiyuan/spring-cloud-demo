package com.wade.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringmsConsumerMovieRibbonPropertiesWithoutEurekaApplication {

	@Bean
	@LoadBalanced
	public RestTemplate newInstance(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringmsConsumerMovieRibbonPropertiesWithoutEurekaApplication.class, args);
	}
}
