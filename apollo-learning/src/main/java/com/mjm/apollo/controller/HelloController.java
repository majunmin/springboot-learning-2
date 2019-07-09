package com.mjm.apollo.controller;

import com.mjm.apollo.config.ParamConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-06-28 20:22
 * @since
 */
@RestController
public class HelloController {

    @Autowired
    private ParamConfig paramConfig;

    @RequestMapping("/hello")
    public String hello(){
        return paramConfig.getHello();
    }
}
