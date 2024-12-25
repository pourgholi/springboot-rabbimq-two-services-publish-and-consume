package com.kubemachine.engine.api.integration;

import com.kubemachine.engine.api.integration.testconfig.EngineTestEngineTestSharedContainerConfig;
import com.kubemachine.engine.api.integration.testconfig.BaseIntegrationTest;
import org.junit.jupiter.api.Test;
import org.microshed.testing.SharedContainerConfig;
import org.springframework.boot.test.context.SpringBootTest;

@SharedContainerConfig(EngineTestEngineTestSharedContainerConfig.class)
@SpringBootTest
class EnginePaymentApplicationTests extends BaseIntegrationTest {
    @Test
    void contextLoads() {
    }
}
