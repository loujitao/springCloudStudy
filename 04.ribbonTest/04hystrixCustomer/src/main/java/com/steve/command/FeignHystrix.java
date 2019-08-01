package com.steve.command;

import com.steve.entity.Person;
import com.steve.feignInterface.PersonFeignClient;
import org.springframework.stereotype.Component;

/**
 * @Description: 这个类提供了接口的失败回调方法
 * @Author: SteveTao
 * @Date: 2019/8/114:57
 **/
@Component
public class FeignHystrix implements PersonFeignClient{
    @Override
    public Person getDataEntity(String name) {
        return new Person();
    }
}
