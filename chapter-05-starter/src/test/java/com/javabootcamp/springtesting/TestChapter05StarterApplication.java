package com.javabootcamp.springtesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestChapter05StarterApplication {

    public static void main(String[] args) {
        SpringApplication.from(Chapter05StarterApplication::main).with(TestChapter05StarterApplication.class).run(args);
    }

}
