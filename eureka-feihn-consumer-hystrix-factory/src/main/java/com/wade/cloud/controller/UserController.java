package com.wade.cloud.controller;

import com.wade.cloud.service.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tingyun on 2017/11/29.
 */
@RestController
public class UserController {


    @Autowired
    private DcClient dcClient;

    @GetMapping("/consumer")
    public String dc(){
        System.err.println("--------------------------------------");
        String result=dcClient.consumer();

        return  result;
    }
}
