package com.steve.feignInterface;

import com.steve.command.FeignHystrix;
import com.steve.entity.Person;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description: 以接口的形式，value对应要调用服务的服务名，path对应服务统一前缀
 *   注：  这个接口可以提到公用模块，服务提供者和服务消费者都依赖这个接口模块，这
 *   样可以统一调用服务接口的调用方式、参数等。
 * @Author: SteveTao
 * @Date: 2019/7/3116:38
 **/
@FeignClient(value = "04ribbon-producer",path = "/person",fallback = FeignHystrix.class)
public interface PersonFeignClient {

    @GetMapping("/data")
   Person getDataEntity(@RequestParam("name") String name);
}
