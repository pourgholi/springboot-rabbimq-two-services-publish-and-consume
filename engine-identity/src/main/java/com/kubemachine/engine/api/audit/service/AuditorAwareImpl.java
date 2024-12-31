package com.kubemachine.engine.api.audit.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;
import java.util.UUID;

public class AuditorAwareImpl implements AuditorAware<UUID> {
    @NotNull
    @Override
    public Optional<UUID> getCurrentAuditor() {
        return Optional.of(UUID.fromString("b1fd855f-a02d-4109-a01e-84a72d91a5e9"));
    }
}
