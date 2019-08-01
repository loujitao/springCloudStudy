package com.steve.feignInterface;

import com.steve.command.Person2HystrixFallbackFactory;
import com.steve.entity.Person;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//注意的是：这里使用的是fallbackFactory属性了，不是fallback
@FeignClient(value = "04ribbon-producer",path = "/person",
        fallbackFactory = Person2HystrixFallbackFactory.class)
public interface Person2FeignClient {

    @GetMapping("/data")
   Person getDataEntity(@RequestParam("name") String name);
}
