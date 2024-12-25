package com.kubemachine.engine.api.integration.testconfig;

import org.microshed.testing.SharedContainerConfiguration;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

import java.time.Duration;

public class EngineTestEngineTestSharedContainerConfig extends EngineTestSharedContainerConfigValues implements SharedContainerConfiguration {
    @Container
    public static PostgreSQLContainer postgreSQLContainer = (PostgreSQLContainer) new PostgreSQLContainer(ENGINE_API_POSTGRES_IMAGE)
            .withDatabaseName(ENGINE_API_DB_NAME)
            .withUsername(ENGINE_API_DB_USERNAME)
            .withPassword(ENGINE_API_DB_PASSWORD)
            .withStartupTimeout(Duration.ofMinutes(3))
            .withExposedPorts(PostgreSQLContainer.POSTGRESQL_PORT);
    @Container
    public static RabbitMQContainer rabbitMQContainer = new RabbitMQContainer(ENGINE_MESSAGE_BROKER_IMAGE)
            .withExposedPorts(ENGINE_MESSAGE_BROKER_PORT)
            .withAccessToHost(ENGINE_MESSAGE_BROKER_ACCESS_TO_HOST)
            .withVhost("/")
            .withUser(ENGINE_MESSAGE_BROKER_USERNAME, ENGINE_MESSAGE_BROKER_PASSWORD)
            .withStartupTimeout(Duration.ofMinutes(3))
            .withPermission("/", "admin", ".*", ".*", ".*");

    @Container
    public static GenericContainer greenMailContainer = new GenericContainer<>(DockerImageName.parse("greenmail/standalone:1.6.1"))
            .waitingFor(Wait.forLogMessage(".*Starting GreenMail standalone.*", 1))
            .withEnv("GREENMAIL_OPTS", "-Dgreenmail.setup.test.smtp -Dgreenmail.hostname=0.0.0.0 -Dgreenmail.users=duke:springboot")
            .withStartupTimeout(Duration.ofMinutes(3))
            .withExposedPorts(3025);

}