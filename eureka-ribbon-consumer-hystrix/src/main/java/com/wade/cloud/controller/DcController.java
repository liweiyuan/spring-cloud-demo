package com.wade.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wade.cloud.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tingyun on 2017/11/13.
 */
@RestController
public class DcController {


    @Autowired
    ConsumerService consumerService;


    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/consumer")
    public String dc(){
        return consumerService.consumer();
    }

    public String fallback(){
        return "fallback";
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/consumer1")
    public String dc1(){
        return consumerService.consumer1();
    }
}
