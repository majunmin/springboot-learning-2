package com.majm.nacos.learn.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("config")
public class ConfigController {

    @NacosValue(value = "${user.name:mjj}", autoRefreshed = true)
    private String userName;

    @NacosValue(value = "${server.port:8220}", autoRefreshed = true)
    private String port;

    @Value("${server.port:8220}")
    private String serverPort;

    @RequestMapping(value = "/getUserName", method = GET)
    public String get() {
        return userName;
    }

    @RequestMapping(value = "/getPort", method = GET)
    public String getPort() {
        return String.format("nacosPort= %s, serverPort = %s", port, serverPort);
    }
}