package com.kubemachine.engine.api.integration.testconfig;

import org.microshed.testing.jupiter.MicroShedTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.junit.jupiter.Testcontainers;

import static com.kubemachine.engine.api.integration.testconfig.EngineTestEngineTestSharedContainerConfig.greenMailContainer;

@Testcontainers
@MicroShedTest
@TestPropertySource(properties = "spring.config.additional-location=classpath:application-integration-test.yml")
public class BaseIntegrationTest extends TestPropertyOverrides {

    @DynamicPropertySource
    static void postgreSqlDbProperties(DynamicPropertyRegistry registry) {
        registry.add(SPRING_DATASOURCE_URL, () -> EngineTestEngineTestSharedContainerConfig.postgreSQLContainer.getJdbcUrl());
    }
}
