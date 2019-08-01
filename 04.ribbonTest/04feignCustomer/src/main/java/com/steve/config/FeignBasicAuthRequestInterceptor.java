package com.steve.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @Description: TODO
 * @Author: SteveTao
 * @Date: 2019/8/111:20
 **/
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        //TODO 自定义权限认证的实现逻辑
    }
}
