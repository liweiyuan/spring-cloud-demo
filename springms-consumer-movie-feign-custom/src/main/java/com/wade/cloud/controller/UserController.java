package com.wade.cloud.controller;

import com.wade.cloud.entity.User;
import com.wade.cloud.feign.UserFeignCustomClient;
import com.wade.cloud.feign.UserFeignCustomSecondClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tingyun on 2017/11/28.
 */
@RestController
public class UserController {

    @Autowired
    private UserFeignCustomClient userFeignCustomClient;

    @Autowired
    private UserFeignCustomSecondClient userFeignCustomSecondClient;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        return userFeignCustomClient.findById(id);
    }

    @GetMapping("/{serviceName}")
    public String findEurekaInfo(@PathVariable String serviceName){
        return userFeignCustomSecondClient.findEurekaInfo(serviceName);
    }

}
