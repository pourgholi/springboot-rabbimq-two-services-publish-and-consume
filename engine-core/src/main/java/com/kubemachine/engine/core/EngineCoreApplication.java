package com.kubemachine.engine.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.kubemachine.engine.*"})
public class EngineCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(EngineCoreApplication.class, args);
    }
}
