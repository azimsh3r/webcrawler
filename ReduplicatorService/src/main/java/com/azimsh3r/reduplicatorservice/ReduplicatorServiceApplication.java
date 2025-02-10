package com.azimsh3r.reduplicatorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ReduplicatorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReduplicatorServiceApplication.class, args);
    }

}
