package com.wade.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringmsSimpleConsumerMovieApplication {

	@Bean
	public RestTemplate newInstance(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringmsSimpleConsumerMovieApplication.class, args);
	}
}
