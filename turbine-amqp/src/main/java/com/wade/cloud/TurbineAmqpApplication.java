package com.wade.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableTurbineStream
@SpringBootApplication
public class TurbineAmqpApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurbineAmqpApplication.class, args);
	}
}
