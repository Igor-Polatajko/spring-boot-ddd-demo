package com.ihorpolataiko.springbootddddemo.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ihorpolataiko.springbootddddemo")
public class SpringBootDddDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDddDemoApplication.class, args);
    }

}
