package com.wade.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tingyun on 2017/11/13.
 * 基于eureka-client端的服务延时
 *  当我们把服务提供者eureka-client中加入了模拟的时间延迟之后，在服务消费端的服务降级逻辑因为hystrix命令调用依赖服务超时，
 *  触发了降级逻辑，但是即使这样，受限于Hystrix超时时间的问题，我们的调用依然很有可能产生堆积。
 */
@Service
public  class ConsumerService {

    @Autowired
    RestTemplate restTemplate;

    //依赖资源定义服务降级逻辑
    //@HystrixCommand(fallbackMethod = "fallback")
    public String consumer(){
        return restTemplate.getForObject("http://eureka-client/dc", String.class);
    }

    public String fallback(){
        return "fallback";
    }

    public String consumer1(){
        return restTemplate.getForObject("http://eureka-client1/dc", String.class);
    }
}
