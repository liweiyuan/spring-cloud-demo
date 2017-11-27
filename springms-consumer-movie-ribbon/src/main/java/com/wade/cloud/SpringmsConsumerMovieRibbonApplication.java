package com.wade.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 电影微服务，使用 Ribbon 在客户端进行负载均衡。
 * LoadBalanced：该负载均衡注解，已经整合了 Ribbon；
 * 在浏览器输入http://localhost:8010/movie/3 地址后，注解 LoadBalanced
 * 会进行负载均衡将请求分配到不同的【用户微服务】上面；
 * Ribbon 的默认负载均衡的算法为：轮询；
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SpringmsConsumerMovieRibbonApplication {

	@Bean
	@LoadBalanced
	public RestTemplate newInstance(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringmsConsumerMovieRibbonApplication.class, args);
	}
}
