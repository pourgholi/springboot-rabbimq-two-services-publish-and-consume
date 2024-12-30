package com.kubemachine.engine.api.identity.configuration;

import com.kubemachine.engine.api.identity.model.Identity;
import com.kubemachine.engine.api.identity.repository.IdentityRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Consumer;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class IdentityStreamConfiguration {

    private final IdentityRepository identityRepository;

    @Bean
    @Transactional
    public Consumer<Identity> processedIdentity() {

        return (identity) -> {
            Identity loadedIdentity = identityRepository.findById(identity.getId()).orElseThrow(EntityNotFoundException::new);
            loadedIdentity.setIdentityStatus(identity.getIdentityStatus());
            loadedIdentity.setProgressStatus(identity.getProgressStatus());
            identityRepository.save(loadedIdentity);
            log.info("Received processed message and saved it: " + identity);
        };
    }
}


