package com.steve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 起多个服务提供者，测试ribbon获取实例信息的API
 * @Author: SteveTao
 * @Date: 2019/7/3016:43
 **/
@RestController
@RequestMapping("/Instance")
public class RibbonClientController {

    @Autowired
    private LoadBalancerClient balancerClient;

    @GetMapping("/choose")
    public Object chooseInstance(){
        //默认的负载均衡策略好像是轮询
        ServiceInstance instance=balancerClient.choose("04ribbon-producer");
        return instance;
    }


}
