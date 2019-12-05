package com.lanou.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServerCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerCloudApplication.class,args);
    }
}
