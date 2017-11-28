package com.wade.cloud.feign;

import com.wade.cloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by tingyun on 2017/11/28.
 */
@FeignClient("springms-provider-user")
public interface UserFeignClient {

    /**
     * 这里有两个坑需要注意：
     * 1、这里需要设置请求的方式为 RequestMapping 注解，用 GetMapping 注解是运行不成功的，即 GetMapping 不支持。
     * 2、注解 PathVariable 里面需要填充变量的名字，不然也是运行不成功的。
     * @param id
     * @return
     */
    @RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long  id);


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User postUser(@RequestBody User user);
}
