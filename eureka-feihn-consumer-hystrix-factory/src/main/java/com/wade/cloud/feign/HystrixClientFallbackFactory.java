package com.wade.cloud.feign;

import com.wade.cloud.service.DcClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by tingyun on 2017/11/29.
 */
@Component
public class HystrixClientFallbackFactory implements FallbackFactory<DcClient> {

    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallbackFactory.class);

    @Override
    public DcClient create(Throwable e) {
        LOGGER.info("fallback; reason was: {}", e.getMessage());
        System.out.println("HystrixClientFallbackFactory.create " +
                Thread.currentThread().getThreadGroup() + " - " + Thread.currentThread().getId() + " - " + Thread.currentThread().getName());
        return new FeignWithDcClient() {
            @Override
            public String consumer() {
                return "this is my house.";
            }
        };
    }
}
