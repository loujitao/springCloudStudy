package com.steve.command;

import com.steve.entity.Person;
import com.steve.feignInterface.Person2FeignClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Description: 通过FallbackFactory来实现回退功能，可以在回调中返回失败的原因
 * @Author: SteveTao
 * @Date: 2019/8/115:13
 **/
@Component
public class Person2HystrixFallbackFactory implements FallbackFactory<Person2FeignClient>{
    @Override
    public Person2FeignClient create(final Throwable throwable) {
        return new Person2FeignClient() {
            @Override
            public Person getDataEntity(String name) {
                Person p=new Person();
                p.setAge(1);
                //这里将异常信息放到了对象的name里返回的
                p.setName(throwable.getMessage());
                return p;
            }
        };
    }
}
