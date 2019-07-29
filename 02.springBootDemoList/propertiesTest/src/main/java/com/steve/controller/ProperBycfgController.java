package com.steve.controller;

import com.steve.config.SteveConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProperBycfgController {

    //第二种加载配置的方式，通过配置文件，并注入到spring容器
    @Autowired
    private SteveConfig steveConfig;

    @GetMapping("/getSteve")
    public String personInfo(){
        return "name:"+ steveConfig.getName()+", age:"+steveConfig.getAge();
    }


}
