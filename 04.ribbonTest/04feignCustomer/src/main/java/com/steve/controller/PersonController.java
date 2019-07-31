package com.steve.controller;

import com.steve.feignInterface.PersonFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 通过注入定义好的feign客户端，直接调用
 * @Author: SteveTao
 * @Date: 2019/7/3116:43
 **/
@RestController
@RequestMapping("/feign")
public class PersonController {

    @Autowired
    private PersonFeignClient feignClient;

    @GetMapping("callHello")
    public String callHello(){
        String result=feignClient.hello();
        System.out.println("调用结果："+ result);
        return result;
    }
}
