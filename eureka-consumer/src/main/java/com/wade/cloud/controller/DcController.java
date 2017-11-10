package com.wade.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tingyun on 2017/11/10.
 */
@RestController
public class DcController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;


    @GetMapping("/consumer")
    public String dc(){
        ServiceInstance serviceInstance=loadBalancerClient.choose("eureka-client");
        String url="http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/dc";
        System.err.println(url);
        return restTemplate.getForObject(url, String.class);
    }
}
