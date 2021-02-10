package com.discovery.serivcediscoveryproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SerivceDiscoveryProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SerivceDiscoveryProjectApplication.class, args);
    }

}
