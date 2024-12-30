package com.kubemachine.engine.core;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.RabbitMQContainer;

@TestConfiguration(proxyBeanMethods = false)
public class TestConfig {
    @Bean
    @ServiceConnection(name = "rabbitmq")
    public RabbitMQContainer rabbitMQContainer() {
        return new RabbitMQContainer("rabbitmq");
    }
}
