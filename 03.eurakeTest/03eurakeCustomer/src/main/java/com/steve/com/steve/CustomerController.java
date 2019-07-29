package com.steve.com.steve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/callHello")
    public String callHello(){
        //通过硬编码调用服务提供者的接口
//        return restTemplate.getForObject("http://localhost:8080/person/hello",String.class);
        //通过服务名调用接口
        return restTemplate.getForObject("http://03eureka-producer/person/hello",String.class);
    }
}
