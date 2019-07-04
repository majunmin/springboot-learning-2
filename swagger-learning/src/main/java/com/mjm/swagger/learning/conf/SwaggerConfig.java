package com.mjm.swagger.learning.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-07-04 16:01
 * @since
 */
@Configuration
public class SwaggerConfig {


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                // .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select()
                // .paths(Predicates.or(PathSelectors.regex("/api/.*")))//过滤的接口
                .apis(RequestHandlerSelectors.basePackage("com.mjm.swagger.learning.controller")) //过滤的接口
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo getApiInfo() {
        // 定义联系人信息
        Contact contact = new Contact("majm","https://github.com/majunmin", "ttyyy@qq.xxx");
        return new ApiInfoBuilder()
                .title("用户信息Admin") // 标题
                .description("管理用户信息,演示Swagger中各种注解的用法") // 描述信息
                .version("2.9.2") // //版本
                .license("-- -- !")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .contact(contact)
                .build();
    }
}
