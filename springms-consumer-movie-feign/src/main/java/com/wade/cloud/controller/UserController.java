package com.wade.cloud.controller;

import com.wade.cloud.entity.User;
import com.wade.cloud.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by tingyun on 2017/11/28.
 */
@RestController
public class UserController {

    @Autowired
    private UserFeignClient userFeignClient;


    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        return userFeignClient.findById(id);
    }

    @GetMapping("/movie/user")
    public User postUser(User user) {
        Random random = new Random();
        User tmpUser = new User();
        long id = (long) random.nextInt(100);
        tmpUser.setId(id);
        tmpUser.setName("TempUser" + id);
        tmpUser.setAge((short) id);

        return userFeignClient.postUser(tmpUser);
    }
}
