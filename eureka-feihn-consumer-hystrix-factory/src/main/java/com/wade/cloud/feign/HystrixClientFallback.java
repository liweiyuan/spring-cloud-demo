package com.wade.cloud.feign;

import com.wade.cloud.service.DcClient;
import org.springframework.stereotype.Component;

/**
 * Created by tingyun on 2017/11/29.
 */
@Component
public class HystrixClientFallback implements DcClient {
    @Override
    public String consumer() {

        System.err.println("this is fallback.");

        return "this is fallback.";
    }
}
