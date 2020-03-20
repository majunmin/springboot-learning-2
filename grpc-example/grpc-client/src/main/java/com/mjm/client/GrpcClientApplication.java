package com.mjm.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Created by majunmin on 2018/11/28.
 */
@SpringBootApplication
@EnableConfigurationProperties
public class GrpcClientApplication {

        public static void main(String[] args) {
            SpringApplication.run(GrpcClientApplication.class, args);
        }
}
