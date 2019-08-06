package com.steve.controller;

import com.steve.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/testGet")
    public String testGet(){
        //请求  GET  无参接口   /person/hello
//         return restTemplate.getForObject("http://03eureka-producer/person/hello",String.class);
        //请求  GET  一参接口   /person/test_param
//         return restTemplate.getForObject("http://03eureka-producer/person/test_param?param={1}",String.class,"参数");
        //请求  GET  一参路径参数接口   /person/test/{path}
//         return restTemplate.getForObject("http://03eureka-producer/person/test/{1}",String.class,"参数");
        //请求  GET  多参接口   /person/test_multiple_param
//         return restTemplate.getForObject("http://03eureka-producer/person/test_multiple_param?name={1}&password={2}",String.class,"用户名","密码");
        //请求  GET  Map参数接口   /person/test_param_map
//        Map<String,String> map=new HashMap<>();
//        map.put("user","stevetao");
//        return restTemplate.getForObject("http://03eureka-producer/person/test_param_map?user={user}",String.class,map);
        //请求  GET  无参返回值为对象接口   /person/user
        Map<String,String> map=new HashMap<>();
        map.put("user","stevetao");
        User user= restTemplate.getForObject("http://03eureka-producer/person/user",User.class);
        return user.getName();
    }


    @GetMapping("/testPost")
    public String testPost(){
        //请求  Post  一参接口   /person/test_post_param  中文会有乱码
//         return restTemplate.postForObject("http://03eureka-producer/person/test_post_param","stevetao",String.class);
        //请求  Post  map参数接口   /person/test_post_map_param
//        Map<String,String> map=new HashMap<>();
//        map.put("user","stevetao");
//        return restTemplate.postForObject("http://03eureka-producer/person/test_post_map_param",map ,String.class);
        //请求  Post  对象参数接口   /person/test_post_entity
        User user=new User("stevetao",27);
        return restTemplate.postForObject("http://03eureka-producer/person/test_post_entity",user ,String.class);

    }


}
