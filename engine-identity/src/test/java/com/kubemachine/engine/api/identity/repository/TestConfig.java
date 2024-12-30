package com.kubemachine.engine.api.identity.repository;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.RabbitMQContainer;

@TestConfiguration(proxyBeanMethods = false)
public class TestConfig {

    @Bean
    @ServiceConnection(name = "postgres")
    public PostgreSQLContainer<?> postgresContainer() {
        return new PostgreSQLContainer<>("postgres");
    }

    @Bean
    @ServiceConnection(name = "rabbitmq")
    public RabbitMQContainer rabbitMQContainer() {
        return new RabbitMQContainer("rabbitmq");
    }
}
