package com.steve.config;

import feign.Logger;
import feign.Request;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: feign的配置，代码的方式
 *       feign默认使用HttpClient来进行接口调用的，可以在pom中集成其他组件，并配置
 *  以替换掉它。
 * @Author: SteveTao
 * @Date: 2019/7/3116:51
 **/
@Configuration
public class FeignConfiguration {

    /**
    *@Author: SteveTao
    *@Description: 日志级别：NONE--不输出日志
     * BASIC    只输出请求方法的URL和响应码、响应时间
     * HEADERS   输出BASIC信息和请求头信息
     * FULL--输出完整日志
    *@Date: 16:54 2019/7/31
    **/
    @Bean
    Logger.Level   feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    /**
    *@Author: SteveTao
    *@Description: 我们调用的接口如果有权限控制，可以在请求头中加入认证信息
    *@Date: 11:18 2019/8/1
    **/
//    @Bean
//    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
//        return new BasicAuthRequestInterceptor("username","xxxxxx");
//    }

    //    @Bean
    public FeignBasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        //使用自定义拦截器实现认证
        return new  FeignBasicAuthRequestInterceptor();
    }

    /**
    *@Author: SteveTao
    *@Description: options可以设置连接超时时间和读取超时时间
     * 第一个参数是连接超时时间，单位ms，默认10*1000
     * 第二个参数是读取超时时间，单位ms，默认60*1000
    *@Date: 11:25 2019/8/1
    **/
    @Bean
    public Request.Options options(){
        return  new Request.Options(5000,1000);
    }

}
