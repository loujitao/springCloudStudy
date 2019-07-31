package com.steve.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: feign的配置，代码的方式
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

}
