package com.wade.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger LOGGER= LoggerFactory.getLogger(DcController.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;


    @GetMapping("/consumer")
    public String dc(){
        LOGGER.error("hello");
        try{
            ServiceInstance serviceInstance=loadBalancerClient.choose("eureka-client");
            String url="http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/dc";
            System.err.println(url);
            return restTemplate.getForObject(url, String.class);
        }catch (Exception e){
            LOGGER.error("dcController: ",Thread.currentThread().getName(),e);
        }
        return null;
    }
}
