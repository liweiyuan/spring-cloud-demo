package com.wade.cloud;

import com.wade.cloud.config.IRuleConfiguation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
@RibbonClient(name = "springms-provider-user",configuration = IRuleConfiguation.class)
@ComponentScan(excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class)})
public class SpringmsConsumerMovieRibbonCustomApplication {


	@Bean
	@LoadBalanced
	public RestTemplate newInstance(){
		return  new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringmsConsumerMovieRibbonCustomApplication.class, args);
	}
}
