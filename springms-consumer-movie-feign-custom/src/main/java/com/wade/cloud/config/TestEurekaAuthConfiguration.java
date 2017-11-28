package com.wade.cloud.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tingyun on 2017/11/28.
 * 配置登录认证
 */
@Configuration
public class TestEurekaAuthConfiguration {


    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("admin","admin");
    }
}
