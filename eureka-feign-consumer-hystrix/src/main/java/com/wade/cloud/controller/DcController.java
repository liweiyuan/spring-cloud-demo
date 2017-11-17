package com.wade.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wade.cloud.service.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tingyun on 2017/11/10.
 */
@RestController
public class DcController {


    @Autowired
    DcClient dcClient;

    /**
     * 表示在10分钟内(60000),如果调取服务超过5秒，调取服务错误个数为1个时，就直接熔断，调取fallback
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallback",
            commandProperties = {@HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "1"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "600000")})//快照时间
    @GetMapping("/consumer")
    public String dc(){
        System.err.println("--------------------------------------");
        String result=dcClient.consumer();
        System.err.println("end**************************");
        return  result;
    }

    public String fallback(){
        System.err.println("hello,world");
        return "fallback";
    }

    @GetMapping("/dc")
    public String getSc(){
        return dcClient.consumer();
    }
}
