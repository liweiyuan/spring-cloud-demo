package com.wade.cloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.wade.cloud.ExcludeFromComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tingyun on 2017/11/27.
 */
@Configuration
@ExcludeFromComponentScan
public class IRuleConfiguation {

    /**
     *
     * @return  随机分配的策略
     */
    @Bean
    public IRule newInstance(){
        return new RandomRule();
    }
}
