package com.wade.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttpClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tingyun on 2017/11/14.
 */
@Configuration
public class ServiceUnit {

   /* @Bean
    @LoadBalanced
    public RestTemplate getHttpClientInstance(){
        RestTemplate restTemplate1=new RestTemplate();
        HttpComponentsClientHttpRequestFactory factory=new HttpComponentsClientHttpRequestFactory();
        factory.setConnectionRequestTimeout(5000);
        factory.setConnectTimeout(5000);
        restTemplate1.setRequestFactory(factory);
        return restTemplate1;
    }*/

    @Bean
    @LoadBalanced
    public RestTemplate getOkHttpInstance(){
        RestTemplate restTemplate=new RestTemplate();
        OkHttpClientHttpRequestFactory factory=new OkHttpClientHttpRequestFactory();
        factory.setConnectTimeout(5000);
        factory.setWriteTimeout(10000);
        restTemplate.setRequestFactory(factory);
        return restTemplate;
    }
}
