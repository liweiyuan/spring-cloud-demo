package com.wade.cloud.service;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by tingyun on 2017/11/10.
 */
//@FeignClient(name = "eureka-client", fallbackFactory = HystrixClientFallbackFactory.class)
public interface DcClient {

    @GetMapping("/dc")
    String consumer();
}
