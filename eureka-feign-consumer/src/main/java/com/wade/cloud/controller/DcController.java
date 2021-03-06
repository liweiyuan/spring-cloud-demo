package com.wade.cloud.controller;

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

    //@HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/consumer")
    public String dc(){
        return dcClient.consumer();
    }

    public String fallback(){
        System.err.println("hello,world");
        return "fallback";
    }
}
