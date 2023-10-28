package com.javabootcamp.springtesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class StarterApplication {

    public static void main(String[] args) {
        SpringApplication.from(com.javabootcamp.springtesting.StarterApplication::main).with(StarterApplication.class).run(args);
    }

}
