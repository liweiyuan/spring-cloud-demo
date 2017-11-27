package com.wade.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 电影微服务，使用 Ribbon 在客户端进行负载均衡。
 * LoadBalanced：该负载均衡注解，已经整合了 Ribbon；
 * 在浏览器输入http://localhost:8010/movie/3 地址后，注解 LoadBalanced
 * 会进行负载均衡将请求分配到不同的【用户微服务】上面；
 * Ribbon 的默认负载均衡的算法为：轮询；
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SpringmsConsumerMovieRibbonApplication {

    @Bean
    @LoadBalanced
    public RestTemplate newInstance() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringmsConsumerMovieRibbonApplication.class, args);
    }
}
/**
 * Ribbon的负载均衡，主要通过LoadBalancerClient来实现的，而LoadBalancerClient具体交给了ILoadBalancer来处理，
 * ILoadBalancer通过配置IRule、IPing等信息，并向EurekaClient获取注册列表的信息，并默认10秒一次向EurekaClient发送“ping”,
 * 进而检查是否更新服务列表，最后，得到注册列表后，ILoadBalancer根据IRule的策略进行负载均衡。
 * 而RestTemplate 被@LoadBalance注解后，能过用负载均衡，主要是维护了一个被@LoadBalance注解的RestTemplate列表，
 * 并给列表中的RestTemplate添加拦截器，进而交给负载均衡器去处理。
 */
