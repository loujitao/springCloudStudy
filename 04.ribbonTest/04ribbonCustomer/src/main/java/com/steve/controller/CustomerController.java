package com.steve.controller;

import com.steve.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    @LoadBalanced   //此注解可以起到负载均衡的作用
    private RestTemplate restTemplate;

    @GetMapping("/callHello")
    public String callHello(){
        return restTemplate.getForObject("http://04ribbon-producer/person/hello",String.class);
    }

    @GetMapping("/data/{name}")
    public String getData(@PathVariable("name") String name){
        return restTemplate.getForObject("http://04ribbon-producer/person/data/{name}",
                String.class,name);
    }

    @GetMapping("/data")
    public Person getDataEntity(@RequestParam("name") String name){
        return restTemplate.getForObject("http://04ribbon-producer/person/data?name="+name,
                Person.class);
    }

    @GetMapping("/save")
    public Long add(){
        Person person=new Person();
        person.setAge(22);
        person.setName("TOM");
        Long id=restTemplate.postForObject("http://04ribbon-producer/person/save",person,Long.class);
        return id;
    }
}
