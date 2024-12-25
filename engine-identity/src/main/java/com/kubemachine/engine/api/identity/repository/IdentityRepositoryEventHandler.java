package com.kubemachine.engine.api.identity.repository;

import com.kubemachine.engine.api.identity.model.Identity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@RepositoryEventHandler
@Slf4j
@Component
@RequiredArgsConstructor
public class IdentityRepositoryEventHandler {

    private final StreamBridge streamBridge;

    @HandleAfterCreate
    public void handleIdentityAfterCreate(Identity identity) {
        streamBridge.send("unprocessed-identity-out-0", identity);
    }
}
