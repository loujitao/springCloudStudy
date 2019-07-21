package com.stevetao;

import com.netflix.discovery.shared.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer    //表明是一个eureka服务
public class SpringEurakeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringEurakeApplication.class,args);
//        new SpringApplicationBuilder(SpringEurakeApplication.class).web(true).run(args);
    }
}
