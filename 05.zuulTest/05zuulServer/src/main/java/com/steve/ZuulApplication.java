package com.steve;

import com.steve.filter.IpFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy  //自带了服务注册@EnableDiscoveryClient注解
public class ZuulApplication {


//    @Bean
//    public IpFilter ipFilter(){
//        return new IpFilter();
//    }

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class,args);
    }
}
