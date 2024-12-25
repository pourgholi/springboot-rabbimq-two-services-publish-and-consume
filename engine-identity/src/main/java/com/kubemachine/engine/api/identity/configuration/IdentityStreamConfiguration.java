package com.kubemachine.engine.api.identity.configuration;

import com.kubemachine.engine.api.identity.model.Identity;
import com.kubemachine.engine.api.identity.repository.IdentityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.function.Consumer;

@Slf4j
@RequiredArgsConstructor
@Component
public class IdentityStreamConfiguration {

    private final IdentityRepository identityRepository;

    @Bean
    @Transactional
    public Consumer<Identity> consumeProcessedIdentity() {

        return (identity) -> {
            Identity loadedIdentity = identityRepository.findById(identity.getId()).orElseThrow(EntityNotFoundException::new);
            loadedIdentity.setIdentityStatus(identity.getIdentityStatus());
            loadedIdentity.setProgressStatus(identity.getProgressStatus());
            identityRepository.save(loadedIdentity);
            log.info("Received processed message and saved it: " + identity);
        };
    }
}


