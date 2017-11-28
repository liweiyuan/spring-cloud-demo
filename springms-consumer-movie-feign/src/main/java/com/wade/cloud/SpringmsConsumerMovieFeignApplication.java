package com.wade.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 电影微服务接入 Feign 进行客户端负载均衡，通过 FeignClient 调用远程 Http 微服务。
 * <p>
 * Feign: Java HTTP 客户端开发的工具。
 * <p>
 * 注解 EnableFeignClients 表示该电影微服务已经接入 Feign 模块。
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class SpringmsConsumerMovieFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringmsConsumerMovieFeignApplication.class, args);
    }
}
