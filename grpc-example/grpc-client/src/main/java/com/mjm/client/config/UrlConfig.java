package com.mjm.client.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by majunmin on 2018/11/28.
 */
@Data
@Component
@ConfigurationProperties("grpc.client.grpc-server")
public class UrlConfig {

    private String host;

    private int port;
}
