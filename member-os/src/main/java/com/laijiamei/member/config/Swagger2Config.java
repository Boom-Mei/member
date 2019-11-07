package com.laijiamei.member.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author jiamei.lai（jiamei.lai@ucarinc.com）
 * @version 1.0
 * @description: Swagger配置类
 * @date 14:24 2019/9/30
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * description:<方法说明>
     * 注意："com.laijiamei.demo.controller" 指的是controller包路径
     * @author jiamei.lai（jiamei.lai@ucarinc.com）
     * @date 2019/9/30 14:26
     * @params [] <参数说明>
     * @return springfox.documentation.spring.web.plugins.Docket <返回值说明>
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.laijiamei.member.controller"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Springboot-api文档")
                .description("").termsOfServiceUrl("")
                .version("1.0").build();
    }

}
