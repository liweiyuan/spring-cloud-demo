package com.wade.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 基于Hystrix断路器功能,进行服务降级
 */
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaRibbonConsumerHystrixApplication {


	@Bean
	@LoadBalanced
	public RestTemplate newInstance(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaRibbonConsumerHystrixApplication.class, args);
	}
}
