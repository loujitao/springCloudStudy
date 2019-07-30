package com.steve.controller;

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
        return restTemplate.getForObject("http://04ribbon-producer/person/hello",String.class);
    }
}
