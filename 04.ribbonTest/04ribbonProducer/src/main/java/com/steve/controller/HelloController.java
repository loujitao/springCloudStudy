package com.steve.controller;

import com.steve.entity.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class HelloController {

    //注解读取配置文件
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hello")
    public String sayHello(){
        //起两个端口的服务提供者，调用服务消费者的/callHello接口，测试ribbon负载均衡
        return "Hello :"+serverPort;
    }

    @GetMapping("/data/{name}")
    public String getData(@PathVariable("name") String name){
        return name;
    }

    @GetMapping("/data")
    public Person getDataEntity(@RequestParam("name") String name){
        return  new Person("steve",27);
    }

    @PostMapping("/save")
    public Long addData(@RequestBody Person person){
        System.out.println(person.getName());
        return 1L;
    }

}
