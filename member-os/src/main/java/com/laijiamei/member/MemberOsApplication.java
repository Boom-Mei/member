package com.laijiamei.member;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan("com.laijiamei.member.dao")
@EnableDubboConfiguration
public class MemberOsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberOsApplication.class, args);
    }

}
