package com.steve.controller;

import com.steve.entity.Person;
import com.steve.feignInterface.PersonFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: feign和hystrix整合  通过feignClient接口统一需要实现的接口
 * @Author: SteveTao
 * @Date: 2019/8/114:50
 **/
@RestController
@RequestMapping("feignHystrix")
public class FeignHystrixController implements PersonFeignClient{

    @Autowired
    private PersonFeignClient feignClient;

    @GetMapping("/data")
    public Person getDataEntity(@RequestParam("name") String name) {
        return feignClient.getDataEntity(name);
    }
}
