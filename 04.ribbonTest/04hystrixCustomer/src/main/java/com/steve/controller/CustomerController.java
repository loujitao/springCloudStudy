package com.steve.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.steve.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hystrix")
public class CustomerController {
    @Autowired
    @LoadBalanced   //此注解可以起到负载均衡的作用
    private RestTemplate restTemplate;

    @GetMapping("/callHello")
    @HystrixCommand(fallbackMethod = "defaultCallHello" ,//指定服务延迟或失败后，调用的方法
          commandProperties = {    //hystrix的属性配置
            @HystrixProperty(
                    name = "execution.isolation.strategy",
                    value = "THREAD"
            )
          }
    )
    public String callHello(){
        return restTemplate.getForObject("http://04ribbon-producer/person/hello",String.class);
    }

    //只启动此服务和注册中心，不启动04ribbon-producer，尝试调用上面的接口
    public String defaultCallHello(){
        return "服务调用失败！";
    }

}
