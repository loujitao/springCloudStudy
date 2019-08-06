package com.steve.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Author: SteveTao
 * @Date: 2019/8/516:24
 **/
@RestController
public class LocalController {

    @GetMapping("/api")
    public String local(){
        return "zuulServer";
    }
}
