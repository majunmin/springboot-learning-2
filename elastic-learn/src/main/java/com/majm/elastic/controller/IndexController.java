package com.majm.elastic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2020/3/1 7:14 下午
 * @since
 */
@RestController
public class IndexController {

    @Value("server.port")
    private String port;


    public String index(){
        return "it works on " + port;
    }
}
