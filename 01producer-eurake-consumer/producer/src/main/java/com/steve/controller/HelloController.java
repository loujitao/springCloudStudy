package com.steve.controller;

import com.steve.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@Slf4j
public class HelloController {
    // 不带参数         http://ip:port/test_no_param
    @RequestMapping("/test_no_param")
    public String testNoParam() {
        return "success";
    }
    // 带有一个参数     http://ip:port/test_param?param=xxx
    @RequestMapping("/test_param")
    public String testParam(@RequestParam String param) {
        return "success, the param is: " + param;
    }
    // 带多个参数      http://ip:port/test_multiple_param?name=xxx&password=zzz
    @RequestMapping("/test_multiple_param")
    public String testMultipleParam(@RequestParam String name, @RequestParam String password) {
        return "success, the name is: " + name + " password is: " + password;
    }
    // map接受参数     http://localhost:8081/test_param_map?key=ss&val=zz
    @RequestMapping("/test_param_map")
    public String testParamMap(@RequestParam Map map) {
        return "success, map: " + map;
    }
    // path参数       http://localhost:8081/test/aas
    @RequestMapping("/test/{path}")
    public String testPath(@PathVariable String path) {
        return "success, path: " + path;
    }
//----------------------- postman客户端插件或者浏览器插件模拟   --------------------------
    // post带一个参数   x-www-form-urlencoded的key-value对方式传参
     //                 raw   json格式传参            key为time
    @PostMapping("/test_post_param")
    public String postParam(@RequestBody String time) {
        return "success, time: " + time;
    }
    // post带Map参数     只能用raw   application/json格式传参   key-value自定义
    @PostMapping("/test_post_map_param")
    public String postMapParam(@RequestBody Map map) {
        return "success, map: " + map;
    }
    // post转实体对象   只能用raw   application/json格式传参   key-value跟实体对应
    @PostMapping("/test_post_entity")
    public String postEntity(@RequestBody User user) {
        log.info("lombok 日志打印！");
        return "success, entity " + user;
    }
    //GET     http://localhost:8081/test_get    浏览器模拟
    @RequestMapping(value = "/test_get", method = RequestMethod.GET)
    public String testGetMethod() {
        return "get method";
    }
    @GetMapping("/test_get_method")
    public String testGet() {
        return "get method";
    }
    // POST      http://localhost:8081/test_post     postman模拟post请求
    @RequestMapping(value = "/test_post", method = RequestMethod.POST)
    public String testPostMethod() {
        return "post method";
    }
    @PostMapping("/test_post_method")
    public String testPost() {
        return "post method";
    }
}