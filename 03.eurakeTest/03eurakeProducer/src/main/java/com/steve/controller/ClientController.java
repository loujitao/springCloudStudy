package com.steve.controller;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*@Author: SteveTao
*@Description: 获取eureka服务的相关信息
*@Date: 16:50 2019/7/29
**/
@RestController
@RequestMapping("/client")
public class ClientController {

//    这个client是netflix带的，算是比较原生的  com.netflix.discovery.EurekaClient
    @Autowired
    private EurekaClient eurekaClient;
//    这个是springCloud 封装了的client  org.springframework.cloud.client.discovery.DiscoveryClient
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/info")
    public Object serviceUrl(){
        return eurekaClient.getInstancesByVipAddress("03eureka-producer",false);
    }

    @GetMapping("/infos")
    public Object servicesUrl(){
        return discoveryClient.getInstances("03eureka-producer");
    }
}
