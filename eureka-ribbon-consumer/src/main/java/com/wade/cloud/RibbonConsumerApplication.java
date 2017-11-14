package com.wade.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 基于Ribbon的服务端消费者
 */
@EnableDiscoveryClient
@SpringBootApplication
public class RibbonConsumerApplication {

	/*@Bean
	@LoadBalanced
	public RestTemplate newInstance(){
		return new RestTemplate();
	}*/
	public static void main(String[] args) {
		SpringApplication.run(RibbonConsumerApplication.class, args);
	}
}
