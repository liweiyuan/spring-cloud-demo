package com.wade.cloud.config;

import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tingyun on 2017/11/28.
 * 自定义配置
 */
@Configuration
public class TestFeignCustomConfiguration {

    @Bean
    public Contract newInstance(){
        return new feign.Contract.Default();
    }

    /**
     * 日志级别配置
     * @return
     */
    @Bean
    Logger.Level feignLoggerLever(){
        return Logger.Level.FULL;
    }
}
