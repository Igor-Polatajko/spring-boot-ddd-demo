package com.ihorpolataiko.springbootddddemo.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication(scanBasePackages = "com.ihorpolataiko.springbootddddemo")
@EnableJdbcRepositories(basePackages = "com.ihorpolataiko.springbootddddemo")
public class SpringBootDddDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDddDemoApplication.class, args);
    }

}
