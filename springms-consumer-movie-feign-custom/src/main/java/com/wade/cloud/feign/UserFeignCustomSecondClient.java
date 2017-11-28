package com.wade.cloud.feign;

import com.wade.cloud.config.TestEurekaAuthConfiguration;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by tingyun on 2017/11/28.
 */
@FeignClient(name = "xxx", url = "http://localhost:8761/", configuration = TestEurekaAuthConfiguration.class)
public interface UserFeignCustomSecondClient {

    @RequestLine(value = "GET /eureka/apps/{serviceName}")
    public String findEurekaInfo(@PathVariable("serviceName") String serviceName);
}
