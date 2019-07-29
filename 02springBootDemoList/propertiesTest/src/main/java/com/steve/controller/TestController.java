package com.steve.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    //第一种通过value注解的方式读取
    @Value("${server.port}")
    private String port;
    @Value("${com.steve.name}")
    private String name;


    @GetMapping("/hello")
    public String hello(){
       String result="port: "+port;
        result+="  name: "+name;
        return result;
    }
}
