package com.kubemachine.engine.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ComponentScan(basePackages = {"com.kubemachine.engine.*"})
public class EngineCoreApplicationTest {

    @Test
    @DisplayName("Testing: contextLoads")
    void contextLoads() {

    }
}
