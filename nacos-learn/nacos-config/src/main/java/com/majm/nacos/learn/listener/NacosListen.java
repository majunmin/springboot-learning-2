package com.majm.nacos.learn.listener;

import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Properties;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2020/3/8 3:32 下午
 * @since
 */
@Component
public class NacosListen {

    @NacosConfigListener(dataId = "example")
    public void listenOnPort(Properties configMap){
        System.out.println("config changed: " + configMap);
    }
}
