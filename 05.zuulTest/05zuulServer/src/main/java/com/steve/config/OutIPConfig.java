package com.steve.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description: 读取黑名单的配置
 * @Author: SteveTao
 * @Date: 2019/8/610:51
 **/
@ConfigurationProperties(prefix = "com.keepout")
@Component
public class OutIPConfig {
    private String IPstr;

    public String getIPstr() {
        return IPstr;
    }

    public void setIPstr(String IPstr) {
        this.IPstr = IPstr;
    }
}
