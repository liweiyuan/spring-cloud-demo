package com.wade.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.Netty4ClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
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

   /* @Bean
    @LoadBalanced
    public RestTemplate getOkHttpInstance(){
        RestTemplate restTemplate=new RestTemplate();
        OkHttpClientHttpRequestFactory factory=new OkHttpClientHttpRequestFactory();
        factory.setConnectTimeout(5000);
        factory.setWriteTimeout(10000);
        restTemplate.setRequestFactory(factory);
        return restTemplate;
    }*/


    /*@Bean
    @LoadBalanced
    public RestTemplate getNetty4Instance() {
        RestTemplate restTemplate = new RestTemplate();
        Netty4ClientHttpRequestFactory factory = new Netty4ClientHttpRequestFactory();
        factory.setConnectTimeout(5000 * 2);
        factory.setReadTimeout(5000 * 2);
        restTemplate.setRequestFactory(factory);
        return restTemplate;
    }*/


    //基于OkHttp3
    @Bean
    @LoadBalanced
    public RestTemplate getOkHttp3Instance(){
        RestTemplate restTemplate=new RestTemplate();
        OkHttp3ClientHttpRequestFactory factory=new OkHttp3ClientHttpRequestFactory();
        //采用默认值
        restTemplate.setRequestFactory(factory);
        return restTemplate;
    }
}
