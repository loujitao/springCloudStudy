package com.steve.config;

import com.steve.compent.MyRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 通过代码的方式配置ribbonClient
 * @Author: SteveTao
 * @Date: 2019/7/3116:16
 **/
//@Configuration
public class RibbonConfig {
    @Bean
    public MyRule rule(){
        return new MyRule();
    }
}
