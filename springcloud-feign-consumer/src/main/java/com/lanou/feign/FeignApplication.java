package com.lanou.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
//开启FeignClients访问功能
@EnableFeignClients
@SpringBootApplication
//开启eureka支持
@EnableEurekaClient
public class FeignApplication {


    public static void main(String[] args) {

        SpringApplication.run(FeignApplication.class,args);
    }
}
