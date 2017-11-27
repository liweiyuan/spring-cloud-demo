package com.wade.cloud.controller;

import com.wade.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tingyun on 2017/11/27.
 */
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        // http://localhost:7900/simple/
        // VIP virtual IP
        // HAProxy Heartbeat

        ServiceInstance serviceInstance = this.loadBalancerClient.choose("springms-provider-user");
        System.out.println(">>>>>" + " " + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());

        return this.restTemplate.getForObject("http://springms-provider-user/simple/" + id, User.class);
    }

    @GetMapping("/choose")
    public String test() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("springms-provider-user");
        System.out.println("00000" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());

        return "choose successful";
    }
}
