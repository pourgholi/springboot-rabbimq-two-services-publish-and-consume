package com.kubemachine.engine.core.identity.configuration;

import com.kubemachine.engine.core.identity.model.Identity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
@Slf4j
public class CoreIdentityStreamConfiguration {
    @Bean
    public Function<Identity, Identity> consumeUnprocessedIdentity() {
        return identity -> {
            log.info("Processing the Identity: " + identity);
            identity.setProgressStatus("PROCESSED");
            identity.setIdentityStatus("CONSOLIDATED");
            return identity;
        };
    }
}
