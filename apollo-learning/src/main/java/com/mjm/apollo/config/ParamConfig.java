package com.mjm.apollo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-06-28 20:21
 * @since
 */
@Data
@Configuration
public class ParamConfig {

    @Value("${hello:noway}")
    private String hello;


}
