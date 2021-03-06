package com.wade.cloud.controller;

import com.wade.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        // http://localhost:7900/simple/
        // VIP：virtual IP
        // HAProxy Heartbeat
        return this.restTemplate.getForObject("http://springms-provider-user/simple/" + id, User.class);
    }

    /**
     * 添加给 springms-sidecar 微服务做测试用的代码。
     *
     * @return
     */
    @GetMapping("/sidecar")
    public String sidecar() {
        return this.restTemplate.getForObject("http://springms-sidecar/", String.class);
    }

    /**
     * 添加给 springms-sidecar 微服务做测试用的代码。
     *
     * @return
     */
    @GetMapping("/sidecar/health.json")
    public String sidecarHealth() {
        return this.restTemplate.getForObject("http://springms-sidecar/health.json", String.class);
    }
}
